package com.student.controller;

import com.student.EntityLayer.Admin;
import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.AdminException;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;
import com.student.serviceLayer.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
    private  AdminService adminService;

    

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String adminEmailId, @RequestParam String password) throws AdminException, LoginException {
        return adminService.LoginAdmin(adminEmailId, password);
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) throws AdminException {
        return adminService.addAdmin(admin);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) throws StudentException {
        return adminService.addStudent(student);
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) throws CourseException {
        return adminService.addCourse(course);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) throws CourseException {
        return adminService.updateCourse(course);
    }

    @PostMapping("/assignCourseToStudent")
    public Student assignCourseToStudent(@RequestBody Student student, @RequestBody Course course) throws CourseException, StudentException {
        return adminService.assignCourseToStudent(student, course);
    }

    @GetMapping("/studentsByName")
    public List<Student> getStudentsByName(@RequestParam String name) throws StudentException {
        return adminService.getStudentsByName(name);
    }

    @GetMapping("/{courseId}/studentsAssigned")
    public List<Student> studentsAssignedToAParticularCourse(@PathVariable Integer courseId) throws StudentException, CourseException {
        return adminService.studentsAssignedToAParticularCourse(courseId);
    }
}
