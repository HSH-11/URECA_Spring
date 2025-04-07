package com.mycom.myapp.register.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.register.dto.CustomerDto;
import com.mycom.myapp.register.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/add")
    public Map<String, String> register(@RequestParam Map<String, String> params) {
        CustomerDto dto = new CustomerDto(
                params.get("userid"),
                params.get("password"),
                params.get("name"),
                params.get("email"),
                params.get("phone"),
                params.get("address")
        );

        boolean success = registerService.registerCustomer(dto);
        Map<String, String> result = new HashMap<>();
        result.put("result", success ? "success" : "fail");
        return result;
    }
}
