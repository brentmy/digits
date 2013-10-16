package models;
/** 
 *@author Brent.
 * 
 * */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  
  /** 
   *
   * @param firstName the first name.
   * @param lastName the last name.
   * @param telephone the telephone.
   * 
   * */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    
  }
  /** 
   * gets first name.
   * @return first name.
   * */
  public String getFirstName() {
    return firstName;
  }
  /** 
   * gets first name.
   * @param firstName.
   * 
   * */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /** 
   * gets first name.
   * @return first name.
   * */
  public String getLastName() {
    return lastName;
  }
  /** 
   * gets last name.
   * @param lastName
   * 
   * */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /** 
   * gets first name.
   * @return telephone.
   * */
  public String getTelephone() {
    return telephone;
  }
  /** 
   * gets Telephone.
   * @param telephone.
   * */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

}
