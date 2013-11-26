package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
/** 
 *@author Brent.
 * 
 * */
@Entity
public class Contact extends Model {
  
  private static final long serialVersionUID = 1L;
  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  
  @ManyToOne
  private UserInfo userInfo;
  
  /** 
   *
   * @param firstName the first name.
   * @param lastName the last name.
   * @param telephone the telephone.
   * @param telephoneType the telephone.
   * 
   * */
  public Contact(String firstName, String lastName, String telephone, String telephoneType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.setTelephoneType(telephoneType);
    
  }
  
  /**
   * 
   * @return map of contacts
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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

  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  
}
