package com.mycom.myapp.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

// jsp 페이지 이동 담당
@Controller
public class PageController {
	
	@GetMapping("/pages/admin")
    public String adminPage() {
        return "adminProductList"; 
    }

    @GetMapping("/page/user")
    public String userPage() {
        return "userPage";
    }
    
    @GetMapping("/register")
    public String RegisterForm() {
        return "register";
    }
}
