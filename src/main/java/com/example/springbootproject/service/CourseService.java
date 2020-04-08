package com.example.springbootproject.service;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Elective;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.repository.CourseRepository;
import com.example.springbootproject.repository.ElectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ElectiveRepository electiveRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    public Course addCourse(Course course) {
        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    public Course getCourse(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course updateCourse(Course course) {
        courseRepository.save(course);
        return course;
    }


    public Elective addElective(int cid, int sid) {
        Student student = userService.getStudent(sid);
        Course course = courseService.getCourse(cid);
        Elective elective = new Elective();
        elective.setCourse(course);
        elective.setStudent(student);
        electiveRepository.save(elective);
        return elective;
    }

    public Elective getElective(int id) {
        return electiveRepository.findById(id).orElse(null);
    }

    public void deleteElective(int id) {
        electiveRepository.deleteById(id);
    }


}
