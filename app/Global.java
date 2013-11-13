/**
 * 
 */
import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
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
    String adminEmail = Play.application().configuration().getString("Digits.admin.email");
    String adminPassword = Play.application().configuration().getString("Digits.admin.password");
    UserInfoDB.addAdmin("Admin", adminEmail, adminPassword);
    if (UserInfoDB.adminExists()) {
    UserInfoDB.addUserInfo("Brent Yoshida", "brent@gmail.com", "password");
    ContactDB.addContact("brent@gmail.com", new ContactFormData("Brent", "Yoshida", "929-999-9999", "Home"));
    ContactDB.addContact("brent@gmail.com", new ContactFormData("Brent1", "Yoshida", "939-999-9999", "Mobile"));
    ContactDB.addContact(adminEmail, new ContactFormData("Brent2", "Soshida", "949-999-9999", "Work"));
    ContactDB.addContact(adminEmail, new ContactFormData("Brent3", "Soshida", "959-999-9999", "Home"));
    }
  }

}
