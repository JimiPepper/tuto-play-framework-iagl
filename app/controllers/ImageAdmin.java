package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

import play.Logger;
import play.Play;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import views.html.listImage;

/**
 * Handles images administration
 * 
 * @author Romain Philippon
 *
 */
@Authenticated(AdminToken.class)
public class ImageAdmin extends Controller {
	
	/**
	 * Stores and save the path of image file
	 * @return
	 */
	public static Result addImage() {
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart picture = body.getFile("picture");
		
		if(picture != null) {
			File formFile = picture.getFile();
			File uploadFile = Play.application().getFile("public/upload/"+ picture.getFilename()).getAbsoluteFile();
			
			/*
			try {
				Files.copy(formFile.toPath(), uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				Logger.error("Can't copy file "+ picture.getFilename() +" in "+ Play.application().getFile("public/upload/").getAbsoluteFile());
			}
			*/
			
			return ok("Faire l'exercice 3");
		}
		
		return ok("Faire l'exercice 3");
	}
}
