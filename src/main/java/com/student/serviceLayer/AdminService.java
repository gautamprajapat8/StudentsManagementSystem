package com.student.serviceLayer;

import java.util.List;

import com.student.EntityLayer.Admin;
import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.AdminException;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;

public interface AdminService {

	public String LoginAdmin(String adminId, String password) throws AdminException,LoginException;

    public Admin addAdmin(Admin admin) throws AdminException;
    public Student addStudent(Student student) throws StudentException;
    public Course addCourse(Course course) throws CourseException;
    public Course updateCourse(Course course) throws CourseException;
    public Student assignCourseToStudent(Student student, Course course) throws CourseException, StudentException;
    public List<Student> getStudentsByName(String name)throws StudentException;
    public List<Student> studentsAssignedToAParticularCourse(Integer courseId) throws StudentException, CourseException;
}
