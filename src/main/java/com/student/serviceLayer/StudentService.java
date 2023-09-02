package com.student.serviceLayer;

import java.sql.Date;
import java.util.List;

import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;

public interface StudentService {

	public String login(Integer student_code,Date date_of_birth) throws StudentException, LoginException;
    public Student updateProfile(Student student) throws StudentException;

    public List<Course> getAllCourseHeAssigned(Integer id) throws CourseException, StudentException;

    public String LeaveCourse(Integer courseId, Integer StudentId) throws CourseException, StudentException;

    
}
