package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//need per...jar

@Entity
@Table(name="userinfo")  
public class UserInfo {
 
	@Id
	@Column(name = "UserID")
    private int userID;
	@Column(name = "username")	
    private String userName;
	@Column(name = "pwd")
    private String pwd;
	@Column(name = "usertype")
    private String userType;
	
	@Transient
	private int age;
   	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
