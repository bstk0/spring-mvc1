package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dbe.dao.EmployeeDAO;
import br.com.dbe.entity.Employee;

@Controller
public class EmployeeController {


	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public String employeeList(Locale locale, Model model) {
		System.out.println("employeeList 2 - Home Page Requested, locale = " + locale);
		//String reqString = new NetClientGet().getPy();
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.getEmployeeList();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("emp", list);

		return "employee/list";
	}
	
	
	@RequestMapping(value = "/employee/form", method = RequestMethod.GET)
	public String employeeForm(Locale locale, Model model) {
		/*
		System.out.println("employeeList 2 - Home Page Requested, locale = " + locale);
		//String reqString = new NetClientGet().getPy();
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = dao.getEmployeeList();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("emp", list);
		*/
		model.addAttribute("employee", new Employee()); 
		return "/employee/form";
	}
	

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	//@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String employeeAdd(@ModelAttribute("employee") Employee emp, Model model) {
		System.out.println("employeeAdd 1 - Home Page Requested, employee.name = " + emp.getName());
		
		//String reqString = new NetClientGet().getPy();
		EmployeeDAO dao = new EmployeeDAO();
		dao.addEmployee(emp);		
		return "redirect:/employee/list";
	}

}
