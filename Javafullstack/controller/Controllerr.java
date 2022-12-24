package com.example.Javafullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Javafullstack.Blueprint.Administrator;
import com.example.Javafullstack.Blueprint.Bank;
import com.example.Javafullstack.Service.BankService;

@Controller
public class Controllerr {
	private BankService bankServ;
	
	public Controllerr(BankService bankServ) {
		this.bankServ = bankServ;
	}

	@GetMapping("/viewAllEmployee")	
public String listOfEmployee(Model model) {
model.addAttribute("EmployeeList",bankServ.fetchAllEmployee());
return "Employee";  //students.html//students-Employee
}
	@PostMapping("/insertEmployee")	
	public String InsertIntoDataBase(@ModelAttribute("Obj") Bank obj) {
		bankServ.saveEmployee(obj);
		return "redirect:/viewAllEmployee";
	}
		
	@GetMapping("Employee/createNewEmployee")
	public String createBank(Model model) {
		Bank emptyObj = new Bank();
		model.addAttribute("Obj", emptyObj);
		return "createEmployee";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteBank(@PathVariable int id) {
		bankServ.deleteEmployeeByid(id);
		//return "success-delete";
		return "redirect:/viewAllEmployee";
	}
	@GetMapping("/update/{id}")
	public String updateEmployeeRecr(@PathVariable int id, Model model) {
		model.addAttribute("updateEmployee", bankServ.getEmployeeById(id));
		//updateEmployee --> updating one record
		return "updateEmployee";
	}
	@PostMapping("/updateAndSave/{id}")//updateEmployee.BankEmployeetId
	public String updateNewValIntoDb(@PathVariable int id,
			@ModelAttribute("updateEmployee") Bank newValFrmFE) {
	Bank exitingObj = bankServ.getEmployeeById(id);
	exitingObj.setEmployeeId(newValFrmFE.getEmployeeId());
	exitingObj.setEmployeeName(newValFrmFE.getEmployeeName());
	exitingObj.setSalary(newValFrmFE.getSalary());
	exitingObj.setEmployeeSec(newValFrmFE.getEmployeeSec());
	bankServ.saveEmployee(exitingObj);
	return "redirect:/viewAllEmployee";
	}
	@GetMapping("/logout")
	public String toLogout() {
		return "logout";
	}
	@GetMapping("/Aboutus")
	public String toaboutus() {
		return "About";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		Administrator admin= new Administrator();
	    model.addAttribute("adminObj",admin);
		return "login";
	}
	@GetMapping("/validatingData")
	public String validateLogin(@ModelAttribute("adminObj")Administrator adminDetails) {
	if(adminDetails.getUserName().equals("adminlogin")&& adminDetails.getPassword().equals("loginPassword")) {
		return "redirect:/viewAllEmployee";
	}
	else {
		return "redirect:/login";
	}
	}
	
	}