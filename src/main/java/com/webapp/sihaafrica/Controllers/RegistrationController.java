package com.webapp.sihaafrica.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.sihaafrica.Models.Businesses;
import com.webapp.sihaafrica.Models.Emailing;
import com.webapp.sihaafrica.Models.Exhibitors;
import com.webapp.sihaafrica.Models.Paiement;
import com.webapp.sihaafrica.Models.Visitors;
import com.webapp.sihaafrica.ServiceImpl.Resources;
import com.webapp.sihaafrica.Services.BusinessesRepository;
import com.webapp.sihaafrica.Services.EmailingRepository;
import com.webapp.sihaafrica.Services.ExhibitorsRepository;
import com.webapp.sihaafrica.Services.PaiementRepository;
import com.webapp.sihaafrica.Services.VisitorsRepository;
import com.webapp.sihaafrica.Services.iBusiness;
import com.webapp.sihaafrica.Services.iExhibitor;



@Controller
public class RegistrationController {
	
	@Autowired
	private ExhibitorsRepository exhibitorsRepository;
	
	@Autowired
	private BusinessesRepository businessesRepository;
	
	@Autowired
	private VisitorsRepository visitorsRepository;
	
	@Autowired
	private EmailingRepository emailingRepository;
	
	@Autowired
	private iExhibitor exhibitorImpl;
	
	@Autowired
	private iBusiness businessImpl;
	
	@Autowired
	private PaiementRepository paiementRepository;
		
	@Autowired
	private HttpSession session;
	
	@Autowired
	private Resources resources;
	
	@PostMapping("/confirmExhibitorRegistration")
	public synchronized String addExhibitor(@Valid @ModelAttribute("exhibitor") Exhibitors exhibitor,
			BindingResult result,Model model, @RequestParam(name = "logo")MultipartFile logo) {
		if((result.hasFieldErrors("companyName"))||(result.hasFieldErrors("companyActivity")||
				(result.hasFieldErrors("companyResponsable")||(result.hasFieldErrors("companyEmail")||
						(result.hasFieldErrors("companyAddress")||
								(result.hasFieldErrors("companyCountry")||
										(result.hasFieldErrors("companyNumber")))))))) {
			model.addAttribute("error","error");
			return "registration/RegistrationExpo";
		}else {
			try {
				exhibitor.setLogo(logo.getBytes());
				exhibitor.setStatus("En attente de paiement");
				exhibitor.setRegistrationDate(LocalDate.now().toString());
				exhibitorsRepository.save(exhibitor);
				String encryptCompanyName = Resources.encryptCompanyName(exhibitor.getCompanyName());
				System.out.println("Encrypted Company Name : "+encryptCompanyName);
				String link = "https://cirtasiaha.com/paiement/"+exhibitor.getCompanyName();
				String message = Resources.getPaiementMessage(link);
				System.out.println("Message : "+message);
				File bonCommande = resources.generateReportCirtaSiaha(exhibitor);
				String adminMessage = resources.getAdministratorMessage(exhibitor.getCompanyName(),"éxposition");
				resources.sendEmail(exhibitor.getCompanyEmail(),"Paiement pour la confirmation du stand",message,bonCommande);
				resources.sendEmailToAdmin("contact@cirtasiaha.com","Bon de commande :"+exhibitor.getCompanyName(), adminMessage, bonCommande);
				model.addAttribute("exhibitorSaveSuccess","exhibitorSaveSuccess");
				return "registration/confirmRegistration";
			}catch(Exception ex) {
				model.addAttribute("errorDownloadLogo","errorDownloadLogo");
				return "registration/RegistrationExpo";
			}
			
		}
	}
	
	@GetMapping("/paiement/{code}")
	public String sendPaiementConfirmation(@PathVariable String code) {
		System.out.println("Company code in confirmation : "+code);
		try {
			session.setAttribute("company",code);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "registration/sentPaiement";
	}
	
	@GetMapping("/paiementb/{code}")
	public String sendPaiementBtoBConfirmation(@PathVariable String code) {
		System.out.println("Company code in confirmation : "+code);
		try {
			session.setAttribute("companyb",code);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "registration/sentPaiementBtoB";
	}
	
	@PostMapping("/sendPaiement")
	public String confirmSendPaiement(@RequestParam(name = "company")String company,
			@RequestParam(name = "paiement")MultipartFile paiementFile) {
		
		Paiement paiement = null;
		boolean result = false;
		Exhibitors exhibitor = exhibitorImpl.findByCompany(company);
		String extension = Resources.getExtensions(paiementFile.getOriginalFilename());
		try {
			paiement = new Paiement(paiementFile.getContentType(),extension, paiementFile.getBytes());
			paiement.setExhibitor(exhibitor);
			paiementRepository.save(paiement);
			result = true;
		}catch(Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		if(!result) {
			return "registration/errorPaiement";
		}else {
			return "registration/confirmPaiement";
		}
	}
	
	@PostMapping("/sendPaiementb")
	public String confirmSendPaiementBtoB(@RequestParam(name = "company")String company,
			@RequestParam(name = "paiement")MultipartFile paiementFile) {
		
		Paiement paiement = null;
		boolean result = false;
		Businesses business = businessImpl.findByCompany(company);
		String extension = Resources.getExtensions(paiementFile.getOriginalFilename());
		try {
			paiement = new Paiement(paiementFile.getContentType(),extension, paiementFile.getBytes());
			paiement.setBusiness(business);
			paiementRepository.save(paiement);
			result = true;
		}catch(Exception ex) {
			ex.printStackTrace();
			result = false;
		}
		if(!result) {
			return "registration/errorPaiement";
		}else {
			return "registration/confirmPaiement";
		}
	}
	
	@GetMapping("/downloadFile/{id}")
	public synchronized ResponseEntity<Resource> downloadFile(@PathVariable String id){
		Exhibitors exhibitor = exhibitorsRepository.findById(Long.parseLong(id)).get();
		String fileName = exhibitor.getCompanyName() + "/" + LocalDate.now().toString();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(exhibitor.getPaiement().getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "." + exhibitor.getPaiement().getExtension())
				.body(new ByteArrayResource(exhibitor.getPaiement().getPaiement()));
	}
	
	@GetMapping("/downloadbFile/{id}")
	public synchronized ResponseEntity<Resource> downloadFileB2B(@PathVariable String id){
		Businesses business = businessesRepository.findById(Long.parseLong(id)).get();
		String fileName = business.getCompanyName() + "/" + LocalDate.now().toString();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(business.getPaiement().getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "." + business.getPaiement().getExtension())
				.body(new ByteArrayResource(business.getPaiement().getPaiement()));
	}
	
	@PostMapping("/confirmBtoBRegistration")
	public String addBtoB(@Valid @ModelAttribute("btob") Businesses businesses,
			BindingResult result,Model model,@RequestParam(name = "logo")MultipartFile logo) {
		if((result.hasFieldErrors("companyName"))||(result.hasFieldErrors("companyActivity")||
				(result.hasFieldErrors("companyResponsable")||(result.hasFieldErrors("companyEmail")||
						(result.hasFieldErrors("companyAddress")||
								(result.hasFieldErrors("companyCountry")||
										(result.hasFieldErrors("companyNumber")))))))) {
			model.addAttribute("error","error");
			return "registration/RegistrationBtoB";
		}else {
			try {
				businesses.setLogo(logo.getBytes());
				businesses.setRegistartionDate(LocalDate.now().toString());
				businesses.setStatus("En attente de paiement");
				businessesRepository.save(businesses);
				//String encryptCompanyName = Resources.encryptCompanyName(businesses.getCompanyName());
				String link = "https://cirtasiaha.com/paiementb/"+businesses.getCompanyName();
				String messageBtoB = Resources.getPaiementBtoBMessage(link);
				String messageAdmin = resources.getAdministratorMessage(businesses.getCompanyName(),"B2B");
				resources.sendEmailWithoutAttach(businesses.getCompanyEmail(),"Réservation reçu pour le B2B", messageBtoB);
				resources.sendEmailWithoutAttach(businesses.getCompanyEmail(),"Réservation B2B de la part de : "+businesses.getCompanyName(),messageAdmin);
				model.addAttribute("bTobSaveSuccess","bTobSaveSuccess");
				return "registration/confirmRegistration";
			}catch(Exception ex) {
				model.addAttribute("errorDownloadLogo","errorDownloadLogo");
				return "registration/RegistrationBtoB";
			}
		}
	}
	
	@PostMapping("/confirmVisitorRegistration")
	public ResponseEntity<Resource> registrationVisitor(
			@RequestParam(name = "name")String name,
			@RequestParam(name = "email")String email,
			@RequestParam(name = "phone")String phone,
			@RequestParam(name = "entreprise")String entreprise,
			@RequestParam(name = "profession")String profession,
			@RequestParam(name = "ville")String ville,
			@RequestParam(name = "interest")String interest,
			@RequestParam(name = "message")String message) {
		Visitors visitor = new Visitors(
				name, email, phone, profession, entreprise, ville, interest
				, "", "", "", message);
		visitorsRepository.save(visitor);
		ResponseEntity<Resource> download = null;
		try {
			PDDocument document = PDDocument.load(new File("eVisit.pdf"));
			PDAcroForm forms = document.getDocumentCatalog().getAcroForm();
			PDField visitorField = forms.getField("visitorName");
			PDField professionField = forms.getField("visitorProfession");
			PDField cityField = forms.getField("visitorCity");
			visitorField.setValue(visitor.getVisitorName());
			professionField.setValue(visitor.getVisitorProfession());
			cityField.setValue(visitor.getVisitorCity());
			//create a temp file
			File temp = File.createTempFile("tempTicket",".pdf");
			document.save(temp);
			document.close();
			String fileName = visitor.getVisitorName().split(" ")[0] + LocalDate.now().toString();
			download = ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + fileName + ".pdf")
					.body(new ByteArrayResource(Files.readAllBytes(temp.toPath())));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return download;
		
	}
	
	@PostMapping("/storeEmails")
	public String storeEmails(@RequestParam(name = "email")String email, Model model) {
		Emailing emailing = new Emailing(email);
		emailingRepository.save(emailing);
		model.addAttribute("emailingSuccess","emailingSuccess");
		return "index/whyVisit";
	}
	
	@PostMapping("/deleteExhibiter")
	public synchronized ResponseEntity<?> deleteExhibiters(@Valid @RequestBody String ids, Errors errors) {
		ids = ids.replace("\"", "");
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body("error");
		}else {
			String [] allIds = ids.split(",");
			for(int i=0;i<allIds.length;i++) {
				//send delete mail
				String email = exhibitorsRepository.findById(Long.parseLong(allIds[i])).get().getCompanyEmail();
				exhibitorsRepository.deleteById(Long.parseLong(allIds[i]));
				resources.sendDeleteEmail(email);
			}
			return ResponseEntity.ok("success");
		}
	}
	
	@PostMapping("/confirmExhibiter")
	public synchronized ResponseEntity<?> confirmExhibiters(@Valid @RequestBody String ids, Errors errors) {
		ids = ids.replace("\"", "");
		boolean allUpdate = true;
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body("error");
		}else {
			String [] allIds = ids.split(",");
			for(int i=0;i<allIds.length;i++) {
				boolean resultUpdate = exhibitorImpl.updateExhibitorStatut(Long.parseLong(allIds[i]),"Paiement confirmé");
				if(!resultUpdate) {
					allUpdate = false;
				}else {
					//send confirmation mail
					String email = exhibitorsRepository.findById(Long.parseLong(allIds[i])).get().getCompanyEmail();
					resources.sendConfirmationEmail(email);
				}
			}
			if(!allUpdate) {
				return ResponseEntity.badRequest().body("errorall");
			}else {
				return ResponseEntity.ok("success");
			}	
		}
	}
	
	@PostMapping("/confirmBtoB")
	public synchronized ResponseEntity<?> confirmBtoB(@Valid @RequestBody String ids, Errors errors) {
		ids = ids.replace("\"", "");
		boolean allUpdate = true;
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body("error");
		}else {
			String [] allIds = ids.split(",");
			for(int i=0;i<allIds.length;i++) {
				boolean resultUpdate = businessImpl.updateBtoBStatus(Long.parseLong(allIds[i]),"Paiement confirmé");
				if(!resultUpdate) {
					allUpdate = false;
				}else {
					//send confirmation mail
					String email = businessesRepository.findById(Long.parseLong(allIds[i])).get().getCompanyEmail();
					resources.sendConfirmationEmail(email);
				}
			}
			if(!allUpdate) {
				return ResponseEntity.badRequest().body("errorall");
			}else {
				return ResponseEntity.ok("success");
			}	
		}
	}
	
	@PostMapping("/deleteBtoB")
	public synchronized ResponseEntity<?> deleteBtoB(@Valid @RequestBody String ids, Errors errors) {
		ids = ids.replace("\"", "");
		if(errors.hasErrors()) {
			return ResponseEntity.badRequest().body("error");
		}else {
			String [] allIds = ids.split(",");
			for(int i=0;i<allIds.length;i++) {
				//send delete mail
				String email = businessesRepository.findById(Long.parseLong(allIds[i])).get().getCompanyEmail();
				businessesRepository.deleteById(Long.parseLong(allIds[i]));
				resources.sendDeleteEmail(email);
			}
			return ResponseEntity.ok("success");
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name = "email")String email,
			@RequestParam(name = "password")String password,Model model) {
		if(email.equalsIgnoreCase("admin@sihaafrica.com")&&password.equalsIgnoreCase("sihaafricadz2020")) {
			return "index/dashboard";
		}else {
			model.addAttribute("errorAuth","errorAuth");
			return "index/admin";
		}
	}
}
