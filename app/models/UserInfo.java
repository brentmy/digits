package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo extends Model {
 
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  private long id;
  private String name;
  private String email;
  private String password;
  private boolean admin;
  
  /**
   * 
   * @return map of Users.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
  }
  
  @OneToMany(mappedBy = "userInfo")
  private List<Contact> contacts = new ArrayList<>();
  
  /**
   * 
   * @return contacts.
   */
  public List<Contact> getContacts() {
    return this.contacts;
  }
  /**
   * @param contact a contact.
   * @return
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * @return id.
   */
  public long getId() {
    return id;
  }
  /**
   * @param id id.
   * @return
   */
  public void setId(long id) {
    this.id = id;
  }
  /**
   * @return the admin
   */
  public boolean isAdmin() {
    return admin;
  }
  /**
   * @param admin the admin to set
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}
