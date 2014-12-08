package controllers;

import models.Comment;

import com.avaje.ebean.Ebean;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security.Authenticated;

/**
 * Handles comment administration
 * 
 * @author Romain Philippon
 */
@Authenticated(AdminToken.class)
public class CommentAdmin extends Controller {
	
	/**
	 * Deletes a comment from its id
	 * @param id
	 * @return
	 */
	public static Result delete(Long id) {
		Ebean.delete(Comment.class, id);
		
		return redirect(routes.ImageAdmin.listImages());
	}
}
