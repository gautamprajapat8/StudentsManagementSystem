package com.student.controller;


import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;
import com.student.serviceLayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
    private  StudentService studentService;

    

    @PostMapping("/login")
    public String login(@RequestParam Integer student_code, @RequestParam Date date_of_birth) throws StudentException, LoginException {
        return studentService.login(student_code, date_of_birth);
    }

    @PutMapping("/updateProfile")
    public Student updateProfile(@RequestBody Student student) throws StudentException {
        return studentService.updateProfile(student);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getAllCoursesAssigned(@PathVariable Integer id) throws CourseException, StudentException {
        return studentService.getAllCourseHeAssigned(id);
    }

    @DeleteMapping("/leaveCourse")
    public String leaveCourse(@RequestParam Integer courseId, @RequestParam Integer studentId) throws CourseException, StudentException {
        return studentService.LeaveCourse(courseId, studentId);
    }
}
