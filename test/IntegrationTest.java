import org.junit.Test;
import play.test.WithBrowser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IntegrationTest extends WithBrowser {

    @Test
    public void test() {
        browser.goTo("/");
        assertTrue(browser.pageSource().contains("Your new application is ready."));
    }

    @Test
    public void endToEndTest() {
        browser.goTo("/github/basav");
        assertTrue(browser.pageSource().contains("Basav Nagur"));
    }

    @Test
    public void runInBrowser() {
        browser.goTo("/github/basav");
        browser.goTo("/github/peter");
        browser.goTo("/users/list");
        assertTrue(browser.pageSource().contains("basav"));
        assertTrue(browser.pageSource().contains("peter"));
        assertNotNull(browser.$("title").getText());
    }

}
