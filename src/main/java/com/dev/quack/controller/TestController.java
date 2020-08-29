package com.dev.quack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dev.quack.models.Student;
import java.util.List;
import com.dev.quack.repository.UserRepo;
import com.dev.quack.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public ModelAndView demo(@RequestParam("name") String name, @RequestParam("fn") String fatherName,
			@RequestParam("str") String stream) {
		// http.setAttribute("name", value);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("father name", fatherName);
		mv.addObject("stream", stream);
		System.out.println("name:-" + name);

		return mv;

	}

	@GetMapping("/demo")
	public Student sencondDemo(@RequestParam("name") String name, @RequestParam("fn") String fatherName,
			@RequestParam("str") String stream) {
		// http.setAttribute("name", value);

		String result = "name:-" + name + "father name:-" + fatherName + "stream" + stream;

		System.out.println("name:-" + name + "father name:-" + fatherName + "stream" + stream);
		Student st = new Student();
		st.setName(name);
		st.setFatherName(fatherName);
		st.setStream(stream);
		// st.setId(1);
		userService.save(st);
		return userService.save(st);
	}
	@PostMapping("/save-student")
	public List<Student> saveStudent(@RequestBody List<Student> stList )
	{
		System.out.println(stList);
		return (List<Student>) userService.saveAll(stList); //"ticket booked : " + stList.size();
	}
	
	@GetMapping("/get-task")
	public Student getTask()
	{
		//System.out.println(stList);
		Student st = new Student();
		st.setName("ajay singh");
		st.setFatherName("giriraj singh");
		st.setStream("java");
		throw new RuntimeException("found problem in fetch student details. please take a look in Webservices");
		
		//return st;  //(List<Student>) userService.findAll();
	}
	@GetMapping(path="/get-student-path/{name}")
	public String getStudentViaPathVairable(@PathVariable String name  )
	{
		String response = "hello"+ ":- "+ name;
		
		return response;  //(List<Student>) userService.findAll();
	}
}
