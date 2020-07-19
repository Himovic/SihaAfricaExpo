package com.webapp.sihaafrica.Controllers;

import java.util.HashMap;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.sihaafrica.Models.Businesses;
import com.webapp.sihaafrica.Models.Exhibitors;
import com.webapp.sihaafrica.Models.Visitors;
import com.webapp.sihaafrica.ServiceImpl.Resources;



@Controller
public class IndexController implements ErrorController {

	private static final String PATH = "/error";
	
	@GetMapping("/")
	public String showIndexPage() {
		return "index/index";
	}
	
	@GetMapping("/admin")
	public String showLoginPage() {
		return "index/admin";
	}
	
	@GetMapping("/exhibitorRegistration/{stand}")
	public synchronized String showExhibitorRegistrationPage(@PathVariable String stand, Model model) {
		if(stand.equalsIgnoreCase("stand=")) {
			model.addAttribute("exhibitor",new Exhibitors());
			return "registration/RegistrationExpo";
		}else {
			int nbrFacade = 0;
			int quotient =0;
			int rest =0;
			int totalFacade = 0;
			String exhibitorFacade = "";
			Exhibitors exhibitor = new Exhibitors();
			exhibitor.setStands(stand.split("=")[1]);
			String [] surfaceStand = stand.split("=")[1].split((","));
			int calculSufrace = surfaceStand.length * 9;
			exhibitor.setSurface(calculSufrace + " M²");
			HashMap<String,Integer> standValues = Resources.getStandValues();
			for(int i=0;i<surfaceStand.length;i++) {
				nbrFacade = nbrFacade + standValues.get(surfaceStand[i]);
			}
			if(surfaceStand.length <= 1 || surfaceStand.length == 2) {
				totalFacade = standValues.get(surfaceStand[0]);
			}else {
				quotient = nbrFacade / 4;
				rest = nbrFacade % 4;
				if((nbrFacade % 2)==0) {
					totalFacade = quotient + rest;
				}else {
					totalFacade = quotient + rest + 1;
				}
			}
			if(totalFacade == 1) {
				exhibitorFacade = "Une seule façade";
			}else if(totalFacade == 2) {
				exhibitorFacade = "Double façades";
			}else if(totalFacade == 3) {
				exhibitorFacade = "Une seule façade + double façades";
			}else if(totalFacade == 4) {
				exhibitorFacade = "02 fois doubles façades";
			}else {
				exhibitorFacade = "02 fois doubles façades";
			}
			exhibitor.setFacade(exhibitorFacade);
			model.addAttribute("exhibitor",exhibitor);
			return "registration/RegistrationExpo";
		}
	}
	
	@GetMapping("/btobRegistration")
	public String showBtoBRegistrationPage(Model model) {
		model.addAttribute("btob",new Businesses());
		return "registration/RegistrationBtoB";
	}
	
	@GetMapping("/visitorRegistration")
	public String showVisitorRegistrationPage(Model model) {
		model.addAttribute("visitor",new Visitors());
		return "registration/RegistrationVisitor";
	}
	
	@GetMapping("/whyExhibit")
	public String showWhyExhibitPage() {
		return "index/whyExhibit";
	}
	
	@GetMapping("/whoExhibit")
	public String showWhoExhibitPage() {
		return "index/whoExhibit";
	}
	
	@GetMapping("/whyVisit")
	public String showWhyVisitPage() {
		return "index/whyVisit";
	}
	
	@GetMapping("/whoVisit")
	public String showWhoVisitPage() {
		return "index/whoVisit";
	}
	
	@GetMapping("/listExhibiters")
	public String showListExhibiters() {
		return "index/listExhibiters";
	}
	
	@GetMapping("/listBtoB")
	public String showListBtoB() {
		return "index/listBtoB";
	}
	
	@GetMapping("/previousEditions")
	public String showpreviousEditionsPage() {
		return "index/previousEditions";
	}
	
	@GetMapping("/plan")
	public String showStandsPlanPage() {
		return "index/plans";
	}
	
	@GetMapping("/program")
	public String showProgramPage() {
		return "index/program";
	}
	
	@GetMapping("/marriott/{type}")
	public String showMarriottRegistration(@PathVariable String type) {
		if(type.equalsIgnoreCase("single")) {
			return "rooming/marriottSingle";
		}else if(type.equalsIgnoreCase("double")) {
			return "rooming/marriottDouble";
		}else {
			return "index/error";
		}	
	}
	
	@GetMapping("/ibis/{type}")
	public String showIbisRegistration(@PathVariable String type) {
		if(type.equalsIgnoreCase("single")) {
			return "rooming/ibisSingle";
		}else if(type.equalsIgnoreCase("double")) {
			return "rooming/ibisDouble";
		}else {
			return "index/error";
		}
	}
	
	@GetMapping("/novotel/{type}")
	public String showNovotelRegistration(@PathVariable String type) {
		if(type.equalsIgnoreCase("single")) {
			return "rooming/novotelSingle";
		}else if(type.equalsIgnoreCase("double")) {
			return "rooming/novotelDouble";
		}else if(type.equalsIgnoreCase("triple")) {
			return "rooming/novotelTriple";
		}else {
			return "index/error";
		}
	}
	
	@RequestMapping(value = PATH)
	public String showError() {
		return "index/error";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
