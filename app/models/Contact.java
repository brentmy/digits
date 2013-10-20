package models;
/** 
 *@author Brent.
 * 
 * */
public class Contact {
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  
  /** 
   *
   * @param id the id.
   * @param firstName the first name.
   * @param lastName the last name.
   * @param telephone the telephone.
   * 
   * */
  public Contact(long id, String firstName, String lastName, String telephone) {
    this.id = id;
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
   * @param firstName is.
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
   * @param lastName is.
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
   * @param telephone i.
   * */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

}
