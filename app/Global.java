import java.io.File;

import com.avaje.ebean.Ebean;

import models.Admin;
import models.Image;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.mvc.*;
import play.libs.F.*;
import static play.mvc.Results.*;
import views.html.*;

/**
 * Overrides default configuration initialization
 * 
 * @author Romain Philippon
 *
 */
public class Global extends GlobalSettings {
	
	// admin account infos
	private static String USERNAME = "jiji";
	private static String PASSWORD = "misa";
	
	@Override
	public Promise<Result> onBadRequest(Http.RequestHeader request, java.lang.String error) {
	    return Promise.<Result>pure(ok(error404.render()));
	} 
	
	@Override
 	public Promise<Result> onHandlerNotFound(Http.RequestHeader request) {
		 return Promise.<Result>pure(ok(error404.render()));	 
 	}
   
   public void onStart(Application app) {
	   /* CREATE DEFAULT ADMIN USER */
	   Admin adminPortFolio = new Admin();
	   adminPortFolio.setPseudo(USERNAME);
	   adminPortFolio.setPassword(PASSWORD);
	   
	  boolean userExists = Ebean.find(Admin.class)
	    		.where()
	    		.eq("pseudo", adminPortFolio.getPseudo())
	    		.eq("password", adminPortFolio.getPassword())
	    		.findUnique() != null;
	   
	   if(userExists) {
		   Logger.debug("Default admin user existed in database with : "+ USERNAME +" as login and "+ PASSWORD +" as password");
	   }
	   else {
		   Ebean.save(adminPortFolio);
		   Logger.info("Default admin user created with : "+ USERNAME +" as login and "+ PASSWORD +" as password");
	   }
	   
	   /* MAKE UPLOAD FOLDER */
	   File publicFolder = Play.application().getFile("public/upload");
	   
	   if(publicFolder.exists()) {
		   Logger.debug("upload folder already created in "+ publicFolder.getAbsolutePath());
	   }
	   else {
		   if(publicFolder.mkdir()) {
			   Logger.info("Create ulpoad folder in "+ publicFolder.getAbsolutePath());
		   }
	   }
	   
	   Logger.info("Portofolio is ready");
   }
}