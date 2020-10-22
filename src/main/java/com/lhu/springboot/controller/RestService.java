package com.lhu.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lhu.springboot.dao.StudentDao;
import com.lhu.springboot.model.Student;

@RestController
public class RestService {
	@Autowired
	StudentDao stu;
	
	@GetMapping(path="rest/student/add",consumes = {"application/xml"})
	public List<Student> addStudent(@RequestBody Student student) {
		stu.save(student);
		return stu.findAll();
	}
	
	
	@GetMapping(path="rest/student/getOne",produces = {"application/xml"})
	//@ResponseBody
	public Student getStudent(@RequestParam("id") int id) {
		return stu.findById(id).orElse(new Student());
	}
	
	@GetMapping("rest/student/getAll")
	public List<Student> getAllStudent() {
		return stu.findAll();
	}
	
	@PutMapping("rest/student/updateOne/{id}")
	public List<Student> getUpdateOrSaveStudent(@RequestBody Student student) {
		stu.save(student);
		return stu.findAll();
	}
	
	@DeleteMapping("rest/student/deleteOne/{id}")
	public List<Student> getDeleteStudent(@RequestParam("id") int id) {
		//Student student = stu.findOne(id);
		Student student = stu.findById(id).orElse(new Student());
		stu.delete(student);
		return stu.findAll();
	}
}
