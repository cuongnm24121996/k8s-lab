package com.cuongnm.department.controller;

import com.cuongnm.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/detail/")
    public Object detail() {
        return departmentService.getEmployees("123");
    }
}
