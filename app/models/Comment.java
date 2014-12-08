package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Represents a comment in the database
 *
 */
@Entity
public class Comment extends Model {
	@Id
	@GeneratedValue
	private int id;
	
	@Required
	private String text;
	
	// @Required
	private String date; 
	
	private String hours;
	
	/*
	@ManyToOne
	@JoinColumn(name="image_id")
	private Image image;
	*/
	
	public Comment() {
		super();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}	
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getHours() {
		return this.hours;
	}
	
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	/*
	public Image getImage() {
		return this.image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	*/
}
