package com.webapp.sihaafrica.ServiceImpl;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.security.Key;
import java.time.LocalDate;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeMessage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Exhibitors;


@Component
public class Resources {
		
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String email,String subject, String message, File bonCommande) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(message,true);
			FileSystemResource file = new FileSystemResource(bonCommande);
			helper.addAttachment("Bon_de_commande.pdf",file);
			javaMailSender.send(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendEmailToAdmin(String email,String subject, String message, File bonCommande) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(message,true);
			FileSystemResource file = new FileSystemResource(bonCommande);
			helper.addAttachment("Bon_de_commande.pdf",file);
			javaMailSender.send(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendEmailWithoutAttach(String email,String subject, String message) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(message,true);
			javaMailSender.send(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getAdministratorMessage(String companyName, String type) {
		StringBuilder builder = new StringBuilder();
		builder.append("<p>Bonjour</p>");
		builder.append("<p>Vous trouverez ci-joint le bon de commande pour la réservation reçu de la"
				+ " part de "+companyName+" pour une "+type+"</p>");
		builder.append("<p>Cordialement</p>");
		return builder.toString();
	}
	
	public static String getPaiementMessage(String link) {
		StringBuilder builder = new StringBuilder();
		builder.append("<p>Bonjour,</p>");
		builder.append("<p>Nous vous remerçions pour l'intérêt que vous avez voulu accorder au Salon"
				+ " Saidalya 2020.</p>");
		builder.append("<p>Nous avons bien reçu votre réservation (PDF en piéce jointe)"
				+ " et vous prions de faire un"
				+ " virement bancaire au montant total, à l’ordre de: <br />" + 
				"Agence Maacom – Constantine <br />" + 
				"Banque CPA, agence Transat 371 <br />" + 
				"Compte N°: 000000000000000000/80 <br />" + 
				"Faute de quoi, votre réservation sera annulée au bout des 48 heures qui suivent.</p>");
		builder.append("<p>Nous vous prions de nous envoyer une copie de l'ordre de virement en cliquant et en "
				+ "la téléchargeant sur le lien suivant <a href="+link+">Cliquer ici</a></p>");
		builder.append("<br />");
		builder.append("<p>Bien à vous,</p>");
		builder.append("<p>L'équipe organisatrice.</p>");
		builder.append("<p>contact@cirtasiaha.com</p>");
		return builder.toString();
	}
	
	public static String getPaiementBtoBMessage(String link) {
		StringBuilder builder = new StringBuilder();
		builder.append("<p>Bonjour,</p>");
		builder.append("<p>Nous vous remerçions pour l'intérêt que vous avez voulu accorder au Salon"
				+ " Saidalya 2020.</p>");
		builder.append("<p>Nous avons bien reçu votre réservation pour assister au B2B"
				+ " et vous prions de faire un"
				+ " virement bancaire au montant total de 10000,00 DA en T.T.C., à l’ordre de: <br />" + 
				"Club des Opérateuers du Tourisme – Constantine <br />" + 
				"Banque CPA, agence Transat 371 <br />" + 
				"Compte N°: 000000000000000000/80 <br />" + 
				"Faute de quoi, votre réservation sera annulée au bout des 48 heures qui suivent.</p>");
		builder.append("<p>Nous vous prions de nous envoyer une copie de l'ordre de virement en cliquant et en "
				+ "la téléchargeant sur le lien suivant <a href="+link+">Cliquer ici</a></p>");
		builder.append("<br />");
		builder.append("<p>Bien à vous,</p>");
		builder.append("<p>L'équipe organisatrice.</p>");
		builder.append("<p>contact@cirtasiaha.com</p>");
		return builder.toString();
	}
	
	public static String encryptCompanyName(String text) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal = c.doFinal(text.getBytes());
        String encrypted = new Base64().encodeAsString(encVal);
        return encrypted;
    }
    
    public static String decryptCompanyName(String text) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedValue = new Base64().decode(text);
        byte[] decValue = c.doFinal(decodedValue);
        String decrypted = new String(decValue);
        return decrypted;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec("lv54ssA887e8s8r6".getBytes(), "AES");
        return key;
    }
    
    public static String getExtensions(String fileName) {
    	String extension = "";
    	int i = fileName.lastIndexOf('.');
    	if (i > 0) {
    	    extension = fileName.substring(i+1);
    	}
    	return extension;
    }
    
    public void sendConfirmationEmail(String email) {
    	StringBuilder builder = new StringBuilder();
		builder.append("<h3>Confirmation de participation au Salon Saidalya 2020</h3>");
		builder.append("<p>Ce présent mail est envoyé pour vous confirmer que nous avons bien reçu "
				+ "votre reçu de paiement et vous confirmer la participation au Salon Saidalya 2020."
				+ "</p>");
		builder.append("<br />");
		builder.append("<p>A trés bientôt.</p>");
		builder.append("<br />");
		builder.append("<p>L'équipe Organisatrice.</p>");
		builder.append("<p>contact@saidalya.com</p>");
		String message = builder.toString();
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(email);
			helper.setSubject("Confirmation de participation.");
			helper.setText(message,true);
			javaMailSender.send(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
    }
    
    public void sendDeleteEmail(String email) {
    	StringBuilder builder = new StringBuilder();
		builder.append("<h3>Annulation de votre stand pour le Salon Saidalya 2020.</h3>");
		builder.append("<p>Ce présent mail est envoyé pour vous annoncer que nous somme dans "
				+ "l'obligation d'annuler votre réservation de stand pour le Salon Saidalya 2020 "
				+ "parce que nous avons pas reçu votre reçu de paiement durant la durée convenue.</p>");
		builder.append("<br />");
		builder.append("<p>Si vous souhaitez participer encore, merci de refaire votre inscription"
				+ "et de nous envoyer le reçu de paiement durant la durée convenue.</p>");
		builder.append("<br />");
		builder.append("Merci pour votre compréhension.");
		builder.append("<br />");
		builder.append("<p>L'équipe Organisatrice.</p>");
		builder.append("<p>contact@saidalya.com</p>");
		String message = builder.toString();
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(email);
			helper.setSubject("Annulation de votre réservation pour le Salon Saidalya 2020.");
			helper.setText(message,true);
			javaMailSender.send(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
    }
    
    public File generateReportCirtaSiaha(Exhibitors exhibitor){
    	File file = null;
    	System.out.println("City : "+exhibitor.getCompanyCity());
    	try {
    		System.out.println("Ex in PDF : "+exhibitor.toString());
    		InputStream in = new URL("https://cirtasiaha.com/assets/Reporting_SihaAfrica.pdf").openStream();
    		PDDocument document = PDDocument.load(in);
    		PDAcroForm forms = document.getDocumentCatalog().getAcroForm();
    		//FIELDS
    		PDField receptionDate = forms.getField("receptionDate");
    		PDField standNumber = forms.getField("standNumber");
    		PDField companyName = forms.getField("companyName");
    		PDField companyActivity = forms.getField("companyActivity");
    		PDField companyAddress = forms.getField("companyAddress");
    		PDField companyPhone = forms.getField("companyPhone");
    		PDField companyFax = forms.getField("companyFax");
    		PDField companyEmail = forms.getField("companyEmail");
    		PDField companyWebsite = forms.getField("companyWebsite");
    		PDField companyResponsable = forms.getField("companyResponsable");
    		PDField companyCitySign = forms.getField("companySignCity");
    		PDField receptionDateSign = forms.getField("companySignDate");
    		PDCheckBox checkboxRegistration = (PDCheckBox) forms.getField("checkboxRegistration");
    		PDCheckBox checkboxOneFacade = (PDCheckBox) forms.getField("checkboxOneFacade");
    		PDCheckBox checkboxTwoFacade = (PDCheckBox) forms.getField("checkboxTwoFacade");
    		PDField total = forms.getField("total");
    		
    		//SET VALUES
    		receptionDate.setValue(LocalDate.now().toString());
    		standNumber.setValue(exhibitor.getStands());
    		companyName.setValue(exhibitor.getCompanyName());
    		companyActivity.setValue(exhibitor.getCompanyActivity());
    		String address = exhibitor.getCompanyAddress() + " / " + exhibitor.getCompanyCity() + " / " + exhibitor.getCompanyCountry();
    		companyAddress.setValue(address);
    		companyPhone.setValue(exhibitor.getCompanyNumber());
    		companyFax.setValue(exhibitor.getCompanyFax());
    		companyEmail.setValue(exhibitor.getCompanyEmail());
    		companyWebsite.setValue(exhibitor.getCompanyWebsite());
    		companyResponsable.setValue(exhibitor.getCompanyResponsable());
    		companyCitySign.setValue(exhibitor.getCompanyCity());
    		receptionDateSign.setValue(LocalDate.now().toString());
    		total.setValue(exhibitor.getMontant()+" DA");
    		checkboxRegistration.check();
    		if(exhibitor.getFacade().equalsIgnoreCase("Une seule façade")) {
    			checkboxOneFacade.check();
    		}else if(exhibitor.getFacade().equalsIgnoreCase("Double façades")) {
    			checkboxTwoFacade.check();
    		}else if(exhibitor.getFacade().equalsIgnoreCase("Une seule façade + double façades")) {
    			checkboxOneFacade.check();
    			checkboxTwoFacade.check();
    		}else if(exhibitor.getFacade().equalsIgnoreCase("02 fois doubles façades")) {
    			checkboxTwoFacade.check();
    		}else {
    			
    		}
    		//create a file
    		String fileName = exhibitor.getCompanyName() + "-" + LocalDate.now().toString();
			file = new File(fileName+".pdf");
    		//file = File.createTempFile(fileName,".pdf");
			document.save(file);
			/*document.close();
			String fileName = exhibitor.getCompanyName() + "-" + LocalDate.now().toString();
			download = ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + fileName + ".pdf")
					.body(new ByteArrayResource(Files.readAllBytes(temp.toPath())));*/
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return file;
    }
    
    public static HashMap<String,Integer> getStandValues(){
    	HashMap<String,Integer> standValues = new HashMap<String,Integer>();
    	standValues.put("01",1);
    	standValues.put("02",2);
    	standValues.put("03",1);
    	standValues.put("04",1);
    	standValues.put("05",1);
    	standValues.put("06",1);
    	standValues.put("07",1);
    	standValues.put("08",2);
    	standValues.put("09",2);
    	standValues.put("10",1);
    	standValues.put("11",1);
    	standValues.put("12",1);
    	standValues.put("13",1);
    	standValues.put("14",1);
    	standValues.put("15",1);
    	standValues.put("16",2);
    	standValues.put("17",1);
    	standValues.put("18",0);
    	standValues.put("19",1);
    	standValues.put("20",1);
    	standValues.put("21",1);
    	standValues.put("22",1);
    	standValues.put("23",2);
    	standValues.put("24",1);
    	standValues.put("25",1);
    	standValues.put("26",1);
    	standValues.put("27",2);
    	standValues.put("28",1);
    	standValues.put("29",2);
    	standValues.put("30",2);
    	standValues.put("31",1);
    	standValues.put("32",2);
    	standValues.put("33",2);
    	standValues.put("34",1);
    	standValues.put("35",2);
    	standValues.put("36",2);
    	standValues.put("37",1);
    	standValues.put("38",2);
    	standValues.put("39",2);
    	standValues.put("40",1);
    	standValues.put("41",2);
    	standValues.put("42",2);
    	standValues.put("43",1);
    	standValues.put("44",2);
    	standValues.put("45",2);
    	standValues.put("46",1);
    	standValues.put("47",2);
    	standValues.put("48",2);
    	standValues.put("49",1);
    	standValues.put("50",2);
    	standValues.put("51",2);
    	standValues.put("52",1);
    	standValues.put("53",2);
    	standValues.put("54",2);
    	standValues.put("55",1);
    	standValues.put("56",2);
    	standValues.put("57",2);
    	standValues.put("58",1);
    	standValues.put("59",2);
    	standValues.put("60",2);
    	standValues.put("61",1);
    	standValues.put("62",2);
    	standValues.put("63",1);
    	standValues.put("64",1);
    	standValues.put("65",1);
    	standValues.put("66",2);
    	standValues.put("67",2);
    	standValues.put("68",1);
    	standValues.put("69",1);
    	standValues.put("70",1);
    	standValues.put("71",1);
    	standValues.put("72",1);
    	standValues.put("73",2);
    	standValues.put("74",1);
    	return standValues;
    }
}
