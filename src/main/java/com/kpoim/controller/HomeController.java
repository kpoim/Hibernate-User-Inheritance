package com.kpoim.controller;

import com.kpoim.entity.Admin;
import com.kpoim.entity.Client;
import com.kpoim.entity.Employee;
import com.kpoim.service.AdminService;
import com.kpoim.service.ClientService;
import com.kpoim.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  ClientService clientService;

  @Autowired
  EmployeeService employeeService;

  @Autowired
  AdminService adminService;

  @GetMapping
  public String home() {
	return "home";
  }

  @GetMapping("/newClient")
  public String newClientForm(@ModelAttribute("client") Client client) {
	return "new-client";
  }

  @PostMapping("/newClient")
  public String newClient(@Valid Client client) {
	clientService.create(client);
	return "redirect:/";
  }

  @GetMapping("/newEmployee")
  public String newEmployeeForm(@ModelAttribute("employee") Employee employee) {
	return "new-employee";
  }

  @PostMapping("/newEmployee")
  public String newEmployee(@Valid Employee employee) {
	employeeService.create(employee);
	return "redirect:/";
  }

  @GetMapping("/newAdmin")
  public String newAdminForm(@ModelAttribute("admin") Admin admin) {
	return "new-admin";
  }

  @PostMapping("/newAdmin")
  public String newAdmin(@Valid Admin admin) {
	adminService.create(admin);
	return "redirect:/";
  }

}
