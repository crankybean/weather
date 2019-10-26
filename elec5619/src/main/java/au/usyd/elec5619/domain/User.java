package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="Id",nullable=false, unique=true)
	private int id;
	
	@Column(name="UserName",nullable=false)
	private String userName;
	
	@Column(name="Password", nullable=false)
	private String password;
	
	@Column(name="Email", nullable=false)
	private String email;
	
//	@Column(name="ProfilePic", nullable=true)
//	private String profilePic;
	@Column(name="gender",nullable=true)
	private String gender;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	public String getProfilePic() {
//		return profilePic;
//	}
//
//	public void setProfilePic(String profilePic) {
//		this.profilePic = profilePic;
//	}
	
	
//	public String toString() {
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("Description: " + description + ";");
//		buffer.append("Price: " + price);
//		return buffer.toString();
//	}
}
