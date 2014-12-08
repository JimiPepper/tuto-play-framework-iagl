package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.avaje.ebean.Ebean;

import models.Comment;
import play.Logger;
import play.data.Form;
import play.mvc.*;
import views.html.addComment;
import views.html.preview;


/**
 *  Handles image displaying and its comments
 *  @author Julia Leven  
 */
public class PreviewImage extends Controller {
	
	final static Form<Comment> addCommentForm = Form.form(Comment.class);
	
	/**
	 * Gets an image from its ID
	 * @param id Image Id
	 * @return image
	 */
	public static Result getImageById(Long id) {
		// return ok(preview.render(Image.find.byId(id), addCommentForm));
		return ok("Je dois implémenter l'ajout d'image");
	}
	
	public static Result formAddComment(Long id) {
		return ok(addComment.render(addCommentForm,id));
	}
	
	/**
	 * Add a comment to an image
	 * @param id
	 * @return
	 */
	public static Result addComment(Long id) {
		/*
		if (addCommentForm.bindFromRequest().hasErrors()) {
		    return badRequest(preview.render(Image.find.byId(id), addCommentForm));
		} 
		else {
			Date date = new Date();
			
			SimpleDateFormat dateFormatDay= new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dateFormatHours= new SimpleDateFormat("hh:mm:ss");
			
		    Comment comment = addCommentForm.bindFromRequest().get();
		    comment.setDate(dateFormatDay.format(date));
		    comment.setHours(dateFormatHours.format(date));
		    
		    Image updatedImage = Image.find.byId(id);
		    updatedImage.addComment(comment);
		    Ebean.update(updatedImage);
		    
		    Logger.info("New comment - "+ comment.getDate());
		}
		
		return redirect(routes.PreviewImage.getImageById(id));
		*/
		
		return ok("Je dois faire l'exercice 3");
	}
}
