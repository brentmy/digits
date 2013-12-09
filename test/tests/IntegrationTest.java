package tests;

import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import tests.pages.IndexPage;
import tests.pages.LoginPage;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Integration tests running on an instance of the application.
 */
public class IntegrationTest {
  /** The port number for the integration test. */
  private static final int PORT = 3333;

  /**
   * Check to see that the two pages can be displayed.
   */
  @Test
  public void testBasicRetrieval() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("Digits");
      }
    });
  }
  /**
   * Check to see that the admin can login and log out.
   */
  @Test
  public void testLogin() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage index = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(index);
        index.login();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.loginToPage();
        assertThat(index.isLoggedIn()).isTrue();
        index.isLoggedOut();
        assertThat(index.isLoggedIn()).isFalse();
      }
    });
  }
  
  @Test
  public void testNewContact() {
    running(testServer(PORT, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        IndexPage index = new IndexPage(browser.getDriver(), PORT);
        browser.goTo(index);
        index.login();
        LoginPage loginPage = new LoginPage(browser.getDriver(), PORT);
        loginPage.isAt();
        loginPage.loginToPage();
        assertThat(index.isLoggedIn()).isTrue();
        index.goToNewContact();
        NewContactPage newContact = new NewContactPage(browser.getDriver(), PORT);
        newContact.isAt();
        newContact.makeContact();
        newContact.goTo(index);
      }
    });
  }

}
