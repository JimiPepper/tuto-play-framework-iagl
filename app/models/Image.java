package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Represents an image in the database
 *
 */
@Entity
public class Image extends Model {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Required
	private String path;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "image")
	private List<Comment> listComment;
	
	public Image() {
		super();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public List<Comment> getListComment() {
		return this.listComment;
	}
	
	public void addComment(Comment comment) {
		this.listComment.add(comment);
		comment.setImage(this);
		comment.save();
	}
}