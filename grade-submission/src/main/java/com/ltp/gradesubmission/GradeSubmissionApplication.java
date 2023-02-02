package com.ltp.gradesubmission;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication @AllArgsConstructor
public class GradeSubmissionApplication implements CommandLineRunner {

	StudentRepository studentRepository;
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
            new Student("Jozef Svajda", LocalDate.parse(("1980-07-31"))),
            new Student("Jozef Kroner", LocalDate.parse(("1980-03-01"))),
            new Student("Zdena Studenkova", LocalDate.parse(("1979-09-19"))),
            new Student("Pavol Hammel", LocalDate.parse(("1980-07-30")))
        };
		
		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}

		Course[] courses = new Course[] {
            new Course("Acting", "AC104", "In this class, you will learn various techniques and skills needed to perform on stage or screen."),
            new Course("Math", "MAT01", "In this class, you will learn the fundamental concepts and problem-solving skills in mathematics, including arithmetic, algebra, geometry, and more."),
            new Course("English", "EN311", "In this class, you will learn language and literature skills, including grammar, vocabulary, reading, writing, and critical analysis."),
            new Course("Sports", "SP393", "In this class, you will learn about teaches students the fundamentals, rules, and techniques of a specific sport or multiple sports."),
            new Course("Informatics", "INF102", "In this class, you will learn the basics of computer science and information technology, including programming, algorithms, data structures, and applications in various fields."),
            new Course("Science", "SC442", "In this class, you will learn about natural phenomena and the scientific method, including biology, chemistry, physics, or other branches of science, as well as critical thinking and problem-solving skills.")
        };

		for (int i = 0; i < courses.length; i++) {
			courseRepository.save(courses[i]);
		}
 
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}	


}
