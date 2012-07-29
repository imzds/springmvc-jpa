package cn.longkai.web.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.longkai.web.entity.Student;
import cn.longkai.web.repository.StudentDao;
import cn.longkai.web.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	@Inject
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Student student) {
		studentDao.persist(student);
	}

}
