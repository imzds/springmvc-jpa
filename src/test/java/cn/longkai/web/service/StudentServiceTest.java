package cn.longkai.web.service;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.longkai.web.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class StudentServiceTest {

	private StudentService service;
	
	@Inject
	public void setService(StudentService service) {
		this.service = service;
	}

	@Test
	public void test() {
		Student student = new Student();
		student.setName("longkai");
		service.save(student);
	}

}
