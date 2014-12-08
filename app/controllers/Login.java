package controllers;

import com.avaje.ebean.Ebean;

import play.Logger;
import play.data.Form;
import models.Admin;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * 
 * Handles login to administration
 * 
 * @author PHILIPPON Romain
 *
 */
public class Login extends Controller {
	
	/**
	 * Displays login form loginAdmin.scala.html
	 * 
	 * @return
	 */
	public static Result index() {
		 if(session().containsKey("username"))
	    	return redirect(routes.ImageAdmin.listImages());
	    else {
	    	Form<Admin> loginForm = Form.form(Admin.class);
			return ok(loginAdmin.render(loginForm));
	    }
	}
	
	/**
	 * Connects user if it is an administrator
	 * @return
	 */
	public static Result connect() {
		Form<Admin> loginForm = Form.form(Admin.class);
		
		if (loginForm.bindFromRequest().hasErrors()) {
		    return badRequest(loginAdmin.render(loginForm));
		} 
		else {
		    Admin user = loginForm.bindFromRequest().get();
		    /* LOOK FOR USER IN SGBD */
		    Admin userSGBD = Ebean.find(Admin.class)
		    		.where()
		    		.eq("pseudo", user.getPseudo())
		    		.eq("password", user.getPassword())
		    		.findUnique();
		    
		    if(userSGBD != null) {
    		/* CREATE SESSION AUTHENTICATION */
		    	session("username", user.getPseudo());
		    }
		    
		    if(session().containsKey("username"))
		    	return redirect(routes.ImageAdmin.listImages());
		    else
		    	return redirect(routes.Login.index());
		}
	}
	
	/**
	 * Disconnects an user from administration
	 * @return
	 */
	public static Result logout() {
		Logger.info(session().get("username") +" disconnected");
		session().clear();
		return redirect(routes.Portfolio.index());
	}
}