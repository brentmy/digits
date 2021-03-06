package controllers;

import java.util.Map;
import models.ContactDB;
import models.UserInfo;
import models.UserInfoDB;
import play.mvc.Controller;
import play.mvc.Security;
import play.data.Form;
import play.mvc.Result;
import views.html.Index;
import views.html.Login;
import views.html.Profile;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.TelephoneType;
import views.html.NewContact;

 /**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result index() {
    UserInfo user = UserInfoDB.getUser(request().username());
    String email = user.getEmail();
    Boolean isLoggedIn = (user != null);
    return ok(Index.render("Home", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        ContactDB.getContacts(email)));
  }
  
  /**
   * Returns new contact form simple form.
   * @param id s.
   * @return The new Contact form.
   */
  @Security.Authenticated(Secured.class)
  public static Result newContact(long id) {
    UserInfo user = UserInfoDB.getUser(request().username());
    String email = user.getEmail();
    Boolean isLoggedIn = (user != null);
    ContactFormData form = id == -1 ? new ContactFormData() : new ContactFormData(ContactDB.getContact(email, id)); 
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(form);
    Map<String, Boolean> telephoneTypeMap = TelephoneType.getTypes(form.telephoneType);
    return ok(NewContact.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData,
        telephoneTypeMap));
    
  }
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }
  /**
   * Handles the posting of data.
   * @return sadas.
   */
  @Security.Authenticated(Secured.class)
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      System.out.println("Errors");
      Map<String, Boolean> telephoneTypeMap = TelephoneType.types();
      return badRequest(NewContact.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
          telephoneTypeMap));
    }
    
    else {
      UserInfo user = UserInfoDB.getUser(request().username());
      String email = user.getEmail();
    ContactFormData data = formData.get();
    ContactDB.addContact(email, data);
    Map<String, Boolean> telephoneTypeMap = TelephoneType.getTypes(data.telephoneType);
        return ok(NewContact.render("New", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, 
            telephoneTypeMap));
    }
  }
  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.profile());
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result profile() {
    return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
}

