package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

import models.Image;
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
	 * List all images stored on the server
	 * @return
	 */
	public static Result listImages() {
		List<Image> list = Ebean.find(Image.class).findList();
		return ok(listImage.render(list));
	}
	
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

			try {
				Files.copy(formFile.toPath(), uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				Logger.error("Can't copy file "+ picture.getFilename() +" in "+ Play.application().getFile("public/upload/").getAbsoluteFile());
			}
			
			Image img = new Image();
			img.setPath("upload/"+ picture.getFilename());
			Ebean.save(img);
			
			flash("success", "Votre image a été uploadée");
			return redirect(routes.ImageAdmin.listImages());    
		} 
		else {
			flash("error", "Missing file");
			return redirect(routes.ImageAdmin.listImages());    
		}
	}
	
	/**
	 * Deletes an image from the server and its reference on the database
	 * @return
	 */
	public static Result removeImage() {
	    Map<String, String[]> map = request().body().asFormUrlEncoded();
	    
	    if (map.size() > 0 ) {
		    String[] imgIDs = map.get("image"); // get selected topics

		    Ebean.delete(Image.class, Arrays.asList(imgIDs));
	    }
	   
		return redirect(routes.ImageAdmin.listImages());
	}
}
