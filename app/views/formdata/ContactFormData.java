package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import play.data.validation.ValidationError;

/**
 * Backing class for form data.
 * @author Brent
 *
 */

public class ContactFormData {

private static final int TELEPHONE = 12;
/** ID #. */
public long id;
/** the First name. */
public String firstName = "";
/** the last name. */
public String lastName = "";
/** the telepone. */
public String telephone = "";
/** Telephone Type. */
public String telephoneType = "";
/** Telephone Type. */
public String level = "";

/**
 * Empty constructor.
 */
public ContactFormData() {
  //empty constructor 
}

/**
 * @param contact the contact.
 * 
 */
public ContactFormData(Contact contact) {
  this.id = contact.getId();
  this.firstName = contact.getFirstName();
  this.lastName = contact.getLastName();
  this.telephone = contact.getTelephone();
  this.telephoneType = contact.getTelephoneType();
  this.level = contact.getLevel();
}

/** Validates the form all fields can't be empty tel is 12 chars. 
 * @return list of errors.
 * 
 * */
public List<ValidationError> validate() {
  List<ValidationError> errors = new ArrayList<>();
  
  if (firstName == null || firstName.length() == 0) {
   errors.add(new ValidationError("firstName", "First Name is Required"));
  }
  
  if (lastName == null || lastName.length() == 0) {
    errors.add(new ValidationError("lastName", "Last Name is Required"));
   }
  
  if (telephone.length() != TELEPHONE || telephone == null || telephone.length() == 0) {
    errors.add(new ValidationError("telephone", "Telephone number is not appropriate length"));
   }
  
  if (!TelephoneType.isType(telephoneType)) {
    errors.add(new ValidationError("telephoneType", "Invalid telephone Type"));
   }
  
  return (errors.isEmpty() ? null : errors);
}

}


