package com.cuongnm.department.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public Authentication whoami(Authentication auth) {
        return auth;
    }
}
