package com.student.EntityLayer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uniqueStudentCode;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
	private String email;
	private String mobileNumber;
	private String parentsName;
	
	

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    // Constructors, getters, setters, and other methods

    public Student() {
        // Default constructor
    }

    

    



	public Student(Integer uniqueStudentCode, @NotNull String name, @NotNull LocalDate dateOfBirth,
			@NotNull String gender, @NotNull String email, @NotNull String mobileNumber, @NotNull String parentsName,
			List<Address> addresses, List<Course> courses) {
		super();
		this.uniqueStudentCode = uniqueStudentCode;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.parentsName = parentsName;
		this.addresses = addresses;
		this.courses = courses;
	}







	// Getter and Setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public String getMobileNumber() {
		return mobileNumber;
	}







	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}







	public String getParentsName() {
		return parentsName;
	}







	public void setParentsName(String parentsName) {
		this.parentsName = parentsName;
	}







	public Integer getUniqueStudentCode() {
		return uniqueStudentCode;
	}



	public void setUniqueStudentCode(Integer uniqueStudentCode) {
		this.uniqueStudentCode = uniqueStudentCode;
	}



	public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses.add(addresses);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses.add(courses);
    }







	@Override
	public String toString() {
		return "Student [uniqueStudentCode=" + uniqueStudentCode + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", email=" + email + ", mobileNumber=" + mobileNumber + ", parentsName="
				+ parentsName + ", addresses=" + addresses + ", courses=" + courses + "]";
	}

    
}
