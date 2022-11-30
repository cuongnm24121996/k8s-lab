package com.cuongnm.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/whoami")
    @ResponseBody
    public String whoami() {
        return "cuongnm";
    }
}
