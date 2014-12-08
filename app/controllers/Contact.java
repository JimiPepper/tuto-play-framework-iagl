package controllers;

import models.forms.ContactMail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

/**
 * Allows users to send email
 * @author Romain Philippon
 *
 */
public class Contact extends Controller {
	
	/**
	 * Default owner's mail address
	 */
	private static String MAIL_SUBJECT = "[PortFolio] Nouveau mail";
	
	/**
	 * Returns a contact form to contact view
	 * @return
	 */
    public static Result contact() {
    	Form<ContactMail> contactForm = Form.form(ContactMail.class);
		return ok(contact.render(contactForm));
    }
    
    /**
     * Send a mail from the contact view
     * @return
     */
    public static Result sendMail() {
    	
    	  /* LOAD SMTP CONFIGURATION */
        String smtpHost = Play.application().configuration().getString("smtp.host");
        Integer smtpPort = Play.application().configuration().getInt("smtp.port");
        String smtpUser = Play.application().configuration().getString("smtp.user");
        String smtpPassword = Play.application().configuration().getString("smtp.password");
        boolean smtpSSLEnabled = Play.application().configuration().getBoolean("smtp.starttls.enable");
        boolean smtpSSLRequired = Play.application().configuration().getBoolean("smtp.auth");
        
        /* LOAD MAIL ADDRESS */
        String myMailAddress = Play.application().configuration().getString("mail.to");
        
        /* GET FORM */
        Form<ContactMail> contactForm = Form.form(ContactMail.class);
        
        if (contactForm.bindFromRequest().hasErrors()) {
		    return badRequest(contact.render(contactForm));
		} 
		else {
	        ContactMail contactMailObj = contactForm.bindFromRequest().get();
	        
	        // PREPARE EMAIL 
	       
	
	        // SMTP CONFIGURATION 
	     
	        // SEND MAIL 
	       
	        return redirect(routes.Portfolio.index());
		}
    }
  
}
