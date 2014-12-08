package controllers;

import play.Logger;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security.Authenticator;

/**
 * Used to identify which are connected in the administration space from those are not
 * 
 * @author PHILIPPON Romain
 *
 */
public class AdminToken extends Authenticator {
   @Override
    public String getUsername(Http.Context ctx) {
	   String pseudo = ctx.session().get("username");
	   
	   if(pseudo != null) {
		   Logger.info(pseudo +" access - "+ ctx.request().path());
	   }
	   
        return pseudo;
    }

    /* @Override
    public Result onUnauthorized(Http.Context ctx) {
    	Logger.error("Somebody try to force administrator access");
        return redirect(routes.Login.index());
    } */
}
