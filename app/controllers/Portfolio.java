package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.mvc.*;
import views.html.*;

/**
 * Default controller for Portfolio application
 * 
 */
public class Portfolio extends Controller {

	/**
	 * Is the Home page application
	 * @return
	 */
    public static Result index() {
    	return ok(index.render());
    }
    
    /**
     * Is the about page of the application
     * @return
     */
    public static Result about() {
  	  return ok(about.render());
    }
    
}
