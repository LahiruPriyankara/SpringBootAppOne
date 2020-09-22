package com.lhu.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lhu.springboot.dao.StudentDao;
import com.lhu.springboot.model.Student;

@Controller
public class HomeController {

	@Autowired
	StudentDao stu;
	
	@RequestMapping("student")
	public String studentHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("value", "Lahiru");
		return "index";
	}
	
	@RequestMapping("student/modelView/{name}")
	public ModelAndView studentHome(@PathVariable("name") String myName ) {
		ModelAndView mv = new ModelAndView("index");
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("index");
		mv.addObject("value",myName);
		return mv;
	}
	
	@RequestMapping("student/model/{name}")
	public String studentHome(@PathVariable("name") String myName,Model model ) {
		model.addAttribute("value",myName);
		return "index";
	}
	
	@RequestMapping("student/addStudent")
	public String addStudent(Student sudent,Model model ) {
		stu.save(sudent);
		model.addAttribute("sudent",sudent);
		model.addAttribute("sudents",stu.findAll());
		return "index";
	}

	@RequestMapping("student/getStudent")
	public String getStudent(@RequestParam("id") int id,Model model ) {
		model.addAttribute("foundSudent",stu.findById(id).orElse(new Student()));
		return "index";
	}
	
	@RequestMapping("student/getStudents")
	public String getStudents(@RequestParam("name") String name,@RequestParam("id") int id,Model model ) {
		System.out.println("id "+id+" | name"+name);
		System.out.println("findByName : "+stu.findByName(name));
		System.out.println("findByAgeGraterThan : "+stu.findByAgeGreaterThan(id));
		System.out.println("findByAgeAndName : "+stu.findByAgeAndName(name,id));
		
		model.addAttribute("findByName"+stu.findByName(name));
		model.addAttribute("findByAgeGreaterThan"+stu.findByAgeGreaterThan(id));
		model.addAttribute("findByAgeAndName"+stu.findByAgeAndName(name,id));
		
		return "index";
	}
	
	@RequestMapping("student/getAllStudent")
	public String getAllStudent(Model model ) {
		model.addAttribute("foundSudent",stu.findAll());
		return "index";
	}
}
