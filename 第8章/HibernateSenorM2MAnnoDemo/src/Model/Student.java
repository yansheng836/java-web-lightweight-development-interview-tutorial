package Model;


import java.util.Set;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column(name="StudentID")
	private String studentID;  
	@Column(name="StudentName")
    private String studentName; 
	
	@ManyToMany
	@Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE })
    @JoinTable(name="Students_Courses",joinColumns={@JoinColumn(name="StudentID")},inverseJoinColumns={@JoinColumn(name="CourseID")})
    private Set<Course> courses;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	} 
    
        
	
}
