package com.student.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.EntityLayer.Admin;
import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;

import java.sql.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String login(Integer student_code, Date date_of_birth) throws StudentException, LoginException {
		Student exitingStudent = studentRepo.findByStudentId(student_code);
		
		if(exitingStudent == null) {
			throw new LoginException("please enter valid student code!");
		}
		else if(exitingStudent.getDateOfBirth().equals(date_of_birth)){

			
			return "Login successful!";

		}else {
			throw new LoginException("Please enter valid date Of birth!!");
		}
	}

	
	@Override
	public Student updateProfile(Student student) throws StudentException {


		Student s=studentRepo.findByStudentId(student.getUniqueStudentCode());
		if(s==null)
		{
			throw new StudentException("Student not exists..!");
		}
		else
		{
			return studentRepo.save(student);
		}
	}

	@Override
	public List<Course> getAllCourseHeAssigned(Integer id) throws CourseException, StudentException {
		
		List<Course> cList=courseRepo.findAll();
		
		List<Course> courses = null;
		
		

		if(cList.size() == 0)
		{
			throw new CourseException("There is no course avalable!!");
		} 
		else 
		{
			
			for(Course c:cList)
			{
				List<Student> sList=c.getStudents();
				for(Student s:sList)
				{
					if(s.getUniqueStudentCode()==id)
					{
						courses.add(c);
					}
				}
			}
			
		}
		
		if(courses==null)
		{
			throw new StudentException("There is no student avalable with id:"+id+" .");
		}
		return courses;
	}

	@Override
	public String LeaveCourse(Integer courseId, Integer StudentId) throws CourseException, StudentException {

		Course c=courseRepo.findByCourseId(courseId);
		if(c==null)
		{
			throw new CourseException("There is no course avalable with id:"+courseId+".");
		}
		
		Student s=studentRepo.findByStudentId(StudentId);
		if(s==null)
		{
			throw new StudentException("There is no Student avalable with id:"+StudentId+".");
		}


		List<Course> courseList=s.getCourses();
		List<Student> studentList=c.getStudents();
		
		for(Course cc:courseList)
		{
			if(cc.getId()==courseId)
			{
				cc=null;
			}
		}
			
		for(Student cs:studentList)
		{
			if(cs.getUniqueStudentCode()==StudentId)
			{
				cs=null;
			}
		}
		return "A student with id"+StudentId+" leave the course with"+courseId+".";
		
	}

    

    

	
}
