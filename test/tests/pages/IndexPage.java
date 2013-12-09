package tests.pages;


import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements index page.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public IndexPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Digits: Index");
  }
/**
 * tests login.
 */
  public void login() {
    find("#login").click();
  }
  
  /**
   * return true if is logged in.
   * @return boolean.
   */
  public boolean isLoggedIn() {
    return !find("#logout").isEmpty();
  }
  
  /**
   * return true if is logged in.
   * 
   */
  public void isLoggedOut() {
     find("#logout").click();
  }
  
  /**
   * goes to new Contact.
   */
  public void goToNewContact() {
    find("#newContact").click();
  }
}