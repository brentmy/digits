/**
 * 
 */
import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;
/**
 * @author Brent
 *
 */
public class Global extends  GlobalSettings {
  /**
   * Inits sample.
   * @param app is app.
   */
  public void onStart(Application app) {
    UserInfoDB.addUserInfo("Brent Yoshida", "brent@gmail.com", "password");
    ContactDB.addContact(new ContactFormData("Brent", "Yosh1", "929-999-9999", "Home"));
    ContactDB.addContact(new ContactFormData("Brent1", "Yosh2", "939-999-9999", "Mobile"));
    ContactDB.addContact(new ContactFormData("Brent2", "Yosh3", "949-999-9999", "Work"));
    ContactDB.addContact(new ContactFormData("Brent3", "Yosh4", "959-999-9999", "Home"));
    
  }

}
