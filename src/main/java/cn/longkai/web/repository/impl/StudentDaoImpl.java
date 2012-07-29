package cn.longkai.web.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import cn.longkai.web.entity.Student;
import cn.longkai.web.repository.StudentDao;

@Repository
public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Student student) {
		entityManager.persist(student);
	}

}
