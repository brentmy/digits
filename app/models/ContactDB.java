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
 private static Map<Long, Contact> contacts = new HashMap<>();
 
 /**
  * Updates contact if 0 and reupdate if not.
  * @param formData the form data.
  * @return contact
  */
public static Contact addContact(ContactFormData formData) {
  Contact contact;
  /* long iD2 = (formData.id == 0) ? contacts.size() + 1 : formData.id;// clean entry
  Contact contact = new Contact(iD2, formData.firstName, formData.lastName, formData.telephone);
  contacts.put(iD2, contact);*/
  if (formData.id == 0) {
    long id = contacts.size() + 1;
    contact = new Contact(id, formData.firstName, formData.lastName, formData.telephone);
    contacts.put(id, contact);
  }
  else {
    contact = new Contact(formData.id, formData.firstName, formData.lastName, formData.telephone);
    contacts.put(formData.id, contact);
  }
  
  return contact;
   }
/**
 * 
 * @return contact
 */
public static List<Contact> getContacts() {
  return new ArrayList<>(contacts.values());
}
/**
 * gets contact.
 * @param id id.
 * @return contact
 */
public static Contact getContact(long id)  {
  Contact contact = contacts.get(id);
  if (contact == null) {
    throw new RuntimeException("Non-Existant ID" + id);
  }
  return contact;
}
 
}
