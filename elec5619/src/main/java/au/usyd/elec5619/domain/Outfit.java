package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Outfit")
public class Outfit implements Serializable{
	
	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Likes")
	private int likes;
	
	@Column(name="Temp")
	private double temp;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String Description) {
		this.description = description;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Likes: " + likes);
		return buffer.toString();
	}
}