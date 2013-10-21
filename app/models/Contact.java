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
  private String telephoneType;
  private String level;
  
  /** 
   *
   * @param id the id.
   * @param firstName the first name.
   * @param lastName the last name.
   * @param telephone the telephone.
   * @param telephoneType the telephone.
   * 
   * */
  public Contact(long id, String firstName, String lastName, String telephone, String telephoneType, String level) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.setTelephoneType(telephoneType);
    this.setLevel(level);
    
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
  /**
   * @return the telephoneType
   */
  public String getTelephoneType() {
    return telephoneType;
  }
  /**
   * @param telephoneType the telephoneType to set
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
  public String getLevel() {
    return level;
  }
  public void setLevel(String level) {
    this.level = level;
  }

  
}
