package com.example.springbootproject.entity;

import com.example.springbootproject.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.TabExpander;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class EntityTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private DirectionElectiveRepository directionElectiveRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private ElectiveRepository electiveRepository;

    @Test
    public void init(){
        Student student = new Student();
        student.setStudentID(2017224446);
        student.setName("敖婷婷");
        studentRepository.save(student);

        Student student02 = new Student();
        student02.setName("裴欣怡");
        studentRepository.save(student02);

        Tutor tutor = new Tutor();
        tutor.setName("王波老师");
        tutorRepository.save(tutor);

        Course course = new Course();
        course.setName("java");
        courseRepository.save(course);

        Course course02 = new Course();
        course02.setName("web");
        courseRepository.save(course02);

        Direction direction = new Direction();
        direction.setName("X系统");
        directionRepository.save(direction);
    }

    @Test
    public void test_TutorToStudent(){
        Tutor tutor = tutorRepository.findById(1).orElse(null);
        Student student = studentRepository.findByStudentID(2017224446);
        student.setTutor(tutor);
        studentRepository.save(student);
    }

    @Test
    public void test_CourseToStudent(){
        Course course = courseRepository.findById(1).orElse(null);
        Student student = studentRepository.findByStudentID(2017224446);
        Elective elective = new Elective();
        elective.setCourse(course);
        elective.setStudent(student);
        elective.setGrade((float)80.0);
        electiveRepository.save(elective);
    }

    @Test
    public void test_DirectionToStudent(){
        Direction direction = directionRepository.findById(1).orElse(null);
        Student student = studentRepository.findByStudentID(2017224446);
        DirectionElective directionElective = new DirectionElective();
        directionElective.setDirection(direction);
        directionElective.setStudent(student);
        directionElectiveRepository.save(directionElective);
    }
}
