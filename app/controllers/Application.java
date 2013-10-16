package controllers;

import models.ContactDB;
import play.mvc.Controller;
import play.data.Form;
import play.mvc.Result;
import views.html.Index;
import views.formdata.ContactFormData;
import views.html.NewContact;
import views.formdata.ContactFormData;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
  
  /**
   * Returns new contact form simple form.
   * @return The new Contact form.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
    
  }
  
  /**
   * Handles the posting of data.
   * @return sadas.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      System.out.println("Errors");
      return badRequest(NewContact.render(formData));
    }
    
    else {
    ContactFormData data = formData.get();
    ContactDB.addContact(data);
    return ok(NewContact.render(formData));
    }
  }
}
