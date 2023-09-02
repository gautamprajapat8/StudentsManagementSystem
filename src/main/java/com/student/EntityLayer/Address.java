package com.student.EntityLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
    
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Specify the generation strategy for the ID
    private Integer id;
    private String area;
    private String state;
    private String district;
    private String pincode;
    private String addressType;
    
	
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uniqueStudentCode")
	private Student student;
    

    // Constructors, getters, setters, and other methods

    public Address() {
        // Default constructor
    }
    

    


	public Address(Integer id, @NotNull String area, @NotNull String state, @NotNull String district,
			@NotNull String pincode, @NotNull String addressType, Student student) {
		super();
		this.id = id;
		this.area = area;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.addressType = addressType;
		this.student = student;
	}





	// Getter and Setter methods


	
    public String getArea() {
        return area;
    }

    public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", area=" + area + ", state=" + state + ", district=" + district + ", pincode="
				+ pincode + ", addressType=" + addressType + ", student=" + student + "]";
	}


	

    
}

