package com.student.EntityLayer;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String courseName;
    private String description;
    private String courseType;
    private Integer duration;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    // Constructors, getters, setters, and other methods

    public Course() {
        // Default constructor
    }

    public Course(String courseName, String description, String courseType, int duration) {
        this.courseName = courseName;
        this.description = description;
        this.courseType = courseType;
        this.duration = duration;
    }

    // Getter and Setter methods

    public Integer getId() {
        return courseId;
    }

    public void Integer(Integer id) {
        this.courseId = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students.add(students);
    }

    @Override
    public String toString() {
        return "Course [id=" + courseId + ", courseName=" + courseName + ", description=" + description + ", courseType="
                + courseType + ", duration=" + duration + "]";
    }
}
