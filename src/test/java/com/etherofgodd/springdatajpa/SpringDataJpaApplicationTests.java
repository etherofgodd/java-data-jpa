package com.etherofgodd.springdatajpa;

import com.etherofgodd.springdatajpa.entities.Guardian;
import com.etherofgodd.springdatajpa.entities.Student;
import com.etherofgodd.springdatajpa.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveStudent(){
		Student student = Student.builder()
				.emailId("test2@test.com")
				.firstName("test2")
				.lastName("testes2")
//				.guardianName("mr test2")
//				.guardianEmail("mrtest2@test.com")
//				.guardianMobile("08098272622")
				.build();

		studentRepository.save(student);
	}

	@Test
	public void saveStudentWithGuardian(){
		Guardian guardian = Guardian.builder()
				.email("guard@test.com")
				.mobile("090992992")
				.name("Guard")
				.build();
		Student student = Student.builder()
				.emailId("test3@test.com")
				.firstName("test2")
				.lastName("testes2")
				.guardian(guardian)
				.build();

		studentRepository.save(student);
	}

	@Test
	public void getAllStudents(){
		List<Student> studentList = studentRepository.findAll();

		System.out.println("StudentList = "+studentList);
	}

	@Test
	public void getStudentByFirstName(){
		List<Student> student = studentRepository.findStudentByFirstName("test");
		System.out.println(student);
	}

	@Test
	public void getStudentByFirstNameContainingString(){
		List<Student> students = studentRepository.findStudentByFirstNameContaining("est");
		System.out.println(students);
	}



}
