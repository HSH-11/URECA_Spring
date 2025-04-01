package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.CarDto;

// Controller에서 작업 처리 후 data(model)을 jsp로 보내서 화면구성 후 client로 전송
@Controller
public class ViewController {

	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		// ....
		return "ViewTest1";
	}

	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		// ....
		return "sub/ViewTest2";
	}

	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		// model
		// service - dao 통해서 data 준비
		model.addAttribute("seq", "12345");
		model.addAttribute("carDto", new CarDto("volvo", 20000, "hsh"));
		return "ViewTest3"; //forwarding
	}
	
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4(Model model) {
		// modelAndView
		// service - dao 통해서 data 준비
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", "12345");
		mav.addObject("carDto", new CarDto("volvo", 20000, "hsh"));
		mav.setViewName("ViewTest4");
		return mav; // forwarding
	}
	
	@GetMapping(value = "/redirect")
	public String redirect() {
		// ...
		return "redirect:/viewTest1"; 
	}
}
