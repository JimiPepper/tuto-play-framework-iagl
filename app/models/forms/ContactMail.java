package models.forms;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

public class ContactMail {
	@Required
	private String message;
	@Required
	@Email
	private String emailSender;
	
	public ContactMail() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getEmailSender() {
		return emailSender;
	}
	
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}
}
