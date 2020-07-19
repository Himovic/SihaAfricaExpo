package com.webapp.sihaafrica.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.sihaafrica.Models.Rooming;
import com.webapp.sihaafrica.Services.RoomingRepository;


@Controller
public class RoomingController {
	/*
	 * NAMING HOTEL
	 * */
	private static final String MARRIOTT_HOTEL = "Hôtel Marriott";
	private static final String IBIS_HOTEL = "Hôtel Ibis";
	private static final String NOVOTEL_HOTEL = "Hôtel Novotel";
	/*
	 * PRICING HOTEL
	 * */
	/*
	 * MARRIOTT HOTEL
	 * */
	private static final double MARRIOTT_HOTEL_SINGLE_PRICE = 13800;
	private static final double MARRIOTT_HOTEL_DOUBLE_PRICE = 16000;
	/*
	 * IBIS HOTEL
	 * */
	private static final double IBIS_HOTEL_SINGLE_PRICE = 5700;
	private static final double IBIS_HOTEL_DOUBLE_PRICE = 6900;
	/*
	 * NOVOTEL HOTEL
	 * */
	private static final double NOVOTEL_HOTEL_SINGLE_PRICE = 7700;
	private static final double NOVOTEL_HOTEL_DOUBLE_PRICE = 9300;
	private static final double NOVOTEL_HOTEL_TRIPLE_PRICE = 11500;
	/*
	 * END PRICING HOTEL
	 * */
	
	@Autowired
	private RoomingRepository roomingRepository;
	
	@PostMapping("/regMarriottSingle")
	public String registerSingleMarriott(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "clientsName")String clientsName,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		
		Rooming rooming = new Rooming(MARRIOTT_HOTEL,MARRIOTT_HOTEL_SINGLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/marriottSingle";
	}
	
	@PostMapping("/regMarriottDouble")
	public String registerDoubleMarriott(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "clientsNameFirst")String clientsNameFirst,
			@RequestParam(name = "clientsNameSecond")String clientsNameSecond,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		String clientsName = clientsNameFirst + "///" + clientsNameSecond;
		Rooming rooming = new Rooming(MARRIOTT_HOTEL,MARRIOTT_HOTEL_DOUBLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/marriottDouble";
	}
	
	@PostMapping("/regIbisSingle")
	public String registerSingleIbis(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "clientsName")String clientsName,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		
		Rooming rooming = new Rooming(IBIS_HOTEL,IBIS_HOTEL_SINGLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/ibisSingle";
	}
	
	@PostMapping("/regIbisDouble")
	public String registerDoubleIbis(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "clientsNameFirst")String clientsNameFirst,
			@RequestParam(name = "clientsNameSecond")String clientsNameSecond,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		String clientsName = clientsNameFirst + "///" + clientsNameSecond;
		Rooming rooming = new Rooming(MARRIOTT_HOTEL,IBIS_HOTEL_DOUBLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/ibisDouble";
	}
	
	@PostMapping("/regNovotelSingle")
	public String registerSingleNovotel(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "clientsName")String clientsName,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		
		Rooming rooming = new Rooming(NOVOTEL_HOTEL,NOVOTEL_HOTEL_SINGLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/novotelSingle";
	}
	
	@PostMapping("/regNovotelDouble")
	public String registerDoubleNovotel(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "clientsNameFirst")String clientsNameFirst,
			@RequestParam(name = "clientsNameSecond")String clientsNameSecond,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		String clientsName = clientsNameFirst + "///" + clientsNameSecond;
		Rooming rooming = new Rooming(NOVOTEL_HOTEL,NOVOTEL_HOTEL_DOUBLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/novotelDouble";
	}
	
	@PostMapping("/regNovotelTriple")
	public String registerTripleNovotel(
			@RequestParam(name = "companyPhone")String companyPhone,
			@RequestParam(name = "clientEmail")String clientEmail,
			@RequestParam(name = "clientsNameFirst")String clientsNameFirst,
			@RequestParam(name = "clientsNameSecond")String clientsNameSecond,
			@RequestParam(name = "clientsNameThird")String clientsNameThird,
			@RequestParam(name = "roomingType")String roomingType,
			@RequestParam(name = "arrivingDate")String arrivingDate,
			@RequestParam(name = "leavingDate")String leavingDate,
			Model model
			) {
		String clientsName = clientsNameFirst + "///" + clientsNameSecond + "///" + clientsNameThird;
		Rooming rooming = new Rooming(NOVOTEL_HOTEL,NOVOTEL_HOTEL_TRIPLE_PRICE,
				companyPhone, roomingType, clientEmail, clientsName, arrivingDate, leavingDate);
		roomingRepository.save(rooming);
		model.addAttribute("success","success");
		return "rooming/novotelTriple";
	}
}
