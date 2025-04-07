package com.mycom.myapp.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

// jsp 페이지 이동 담당
@Controller
public class PageController {
	
	@GetMapping("/adminPage")
    public String adminPage() {
        return "adminPage"; 
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "userPage";
    }
}
