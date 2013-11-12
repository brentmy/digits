package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * database for contacts.
 * @author Brent
 *
 */
public class ContactDB {
 private static Map<String, Map<Long, Contact>> contacts = new HashMap<String, Map<Long, Contact>>();
 
 /**
  * Updates contact if 0 and reupdate if not.
  * @param email for user. 
  * formData the form data.
  * @return contact
  */
public static Contact addContact(String email, ContactFormData formData) {
  long iD2 = (formData.id == 0) ? contacts.size() + 1 : formData.id; // clean entry
   long id = contacts.size() + 1;
   Contact contact = new Contact(id, formData.firstName, formData.lastName, formData.telephone, formData.telephoneType);
   if (!contacts.containsKey(email)) {
     contacts.put(email, new HashMap<Long, Contact>());
   }
  contacts.get(email).put(iD2, contact);
  return contact;
   }
/**
 * @param email the email.
 * @return contact
 */
public static List<Contact> getContacts(String email) {
  if (!contacts.containsKey(email)) {
    return null;
  }
  return new ArrayList<>(contacts.get(email).values());
}
/**
 * gets contact.
 * @param id id. email email.
 * @return contact
 */
public static Contact getContact(String email, long id)  {
  if (!contacts.containsKey(email)) {
    throw new RuntimeException("Non-Existant Email" + email);
  }
  Contact contact = contacts.get(email).get(id);
  if (contact == null) {
    throw new RuntimeException("Non-Existant ID" + id);
  }
  return contact;
}
 
}
