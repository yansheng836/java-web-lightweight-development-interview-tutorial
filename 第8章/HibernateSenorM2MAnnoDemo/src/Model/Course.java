package Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	@Column(name = "CourseID")
	private String courseID;  
	@Column(name = "CourseName")
    private String courseName;
	
	@ManyToMany  
	@Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@JoinTable(name="Students_Courses",joinColumns={@JoinColumn(name="CourseID")},inverseJoinColumns={@JoinColumn(name="StudentID")})  
    private Set<Student> students;
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}	
		

	
}
