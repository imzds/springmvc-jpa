package cn.longkai.web.controller;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.longkai.web.entity.Student;
import cn.longkai.web.service.StudentService;

@Controller
@Scope("prototype")
@RequestMapping("/student/")
public class StudentController {

	private StudentService studentService;

	@Inject
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping({"/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("msg", "hello!");
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("username") String name, Model model) {
		Student student = new Student();
		student.setName(name);
		studentService.save(student);
		int id = student.getId();
		model.addAttribute("id", id);
		return "result";
	}
	
}
