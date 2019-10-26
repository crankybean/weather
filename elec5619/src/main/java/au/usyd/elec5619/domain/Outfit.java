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
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Style")
	private int style;
	
	@Column(name="Likes")
	private int likes;
	
	@Column(name="Temp")
	private double temp;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStyle() {
		return style;
	}
	
	public void setStyle(int style) {
		this.style = style;
	}
	
	public long getLikes() {
		return likes;
	}
	
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Style: " + style + ";");
		buffer.append("Likes: " + likes);
		return buffer.toString();
	}
}