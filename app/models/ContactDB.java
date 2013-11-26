package models;

import java.util.List;
import views.formdata.ContactFormData;

/**
 * database for contacts.
 * @author Brent
 *
 */
public class ContactDB {
 
 /**
  * Updates contact if 0 and reupdate if not.
  * @param email for user, formData the form data.
  * @param formData is form data.
  * @return
  */
public static void addContact(String email, ContactFormData formData) {
  boolean newContact = (formData.id == -1);
  if (newContact) {
   Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
   UserInfo userInfo = UserInfo.find().where().eq("email", email).findUnique();
   if (userInfo == null) {
     throw new RuntimeException("Could Not Find user");
    }
  userInfo.addContact(contact);
  contact.setUserInfo(userInfo);
  userInfo.save();
  contact.save();
  }
  else {
    Contact contact = Contact.find().byId(formData.id);
    contact.setFirstName(formData.firstName);
    contact.setLastName(formData.lastName);
    contact.setTelephone(formData.telephone);
    contact.setTelephoneType(formData.telephoneType);
    contact.save();
  }
   }
/**
 * @param email the email.
 * @return contact
 */
public static List<Contact> getContacts(String email) {
 UserInfo userInfo = UserInfo.find().where().eq("email", email).findUnique();
 if (userInfo == null) {
   return null;
 }
 else {
   return userInfo.getContacts();
 }
}
/**
 * 
 * @param email email.
 * @return true or false.
 */
public static boolean isUser(String email) {
  return (UserInfo.find().where().eq("email", email).findUnique() != null);
}
/**
 * gets contact.
 * @param email email.
 * @param id id.
 * @return contact
 */
public static Contact getContact(String email, long id)  {
  Contact contact = Contact.find().byId(id);
  if (contact == null) {
    throw new RuntimeException("Does Not Exist" + id);
  }
  UserInfo userInfo = contact.getUserInfo();
  if (!email.equals(userInfo.getEmail())) {
    throw new RuntimeException("Non-Existant User" + email);
  }
  return contact;
}
 
}
