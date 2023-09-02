package com.student.serviceLayer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.EntityLayer.Admin;
import com.student.EntityLayer.Course;
import com.student.EntityLayer.Student;
import com.student.exception.AdminException;
import com.student.exception.CourseException;
import com.student.exception.LoginException;
import com.student.exception.StudentException;
import com.student.repository.AdminRepository;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	
	
	@Override
	public String LoginAdmin(String adminId, String password) throws LoginException, AdminException {
		
		Admin exitingAdmin = adminRepo.findByEmailId(adminId);
		
		if(exitingAdmin == null) {
			throw new LoginException("please enter valid emailId!");
		}
		else if(exitingAdmin.getPassword().equals(password)){

			
			return "Login successful!";

		}else {
			throw new LoginException("Please enter valid password!!");
		}
	}

	
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		
			return adminRepo.save(admin);

	}
	

	@Override
	public Student addStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Course addCourse(Course course) throws CourseException {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course course) throws CourseException {
		
		Course c=courseRepo.findByCourseId(course.getId());
		if(c==null)
		{
			throw new CourseException("Corse not exists..!");
		}
		else
		{
			return courseRepo.save(course);
		}
	}

	@Override
	public Student assignCourseToStudent(Student student, Course course) throws CourseException, StudentException {
		// TODO Auto-generated method stub
		Course c=courseRepo.findByCourseId(course.getId());
		Student s=studentRepo.findByStudentId(student.getUniqueStudentCode());
		if(c==null)
		{
			throw new CourseException("Corse not exists..!");
		}
		else if(s==null)
		{
			throw new StudentException("Student not exists..!");
		}
		
		student.setCourses(course);
		course.setStudents(student);
		
		
		
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentException {
		
		List<Student> studentList=studentRepo.findAll();
		
		List<Student> nstudent = null;
		
		

		if (studentList.size() == 0) {
			throw new StudentException("There is no student avalable!!");
		} else {
			for(Student s:studentList)
			{
				if(s.getName().equals(name))
				{
					nstudent.add(s);
				}
			}
			
		}
		
		
		return nstudent;
	}

	@Override
	public List<Student> studentsAssignedToAParticularCourse(Integer courseId)
			throws StudentException, CourseException {
		List<Student> studentList=studentRepo.findAll();
		
		List<Student> nstudent = null;
		
		

		if (studentList.size() == 0) {
			throw new StudentException("There is no student avalable!!");
		}
		else 
		{
			for(Student s:studentList)
			{
				List<Course> lCourse=s.getCourses();
				
				for(Course c:lCourse)
				{
					if(c.getId()==courseId)
					{
						nstudent.add(s);
						break;
					}
				}
				
				
			}
			
		}
		
		if (nstudent.size() == 0) {
			throw new StudentException("There is no student avalable with course id: "+courseId+".");
		}
		else 
		{
		
			return nstudent;
		}
	}

}
