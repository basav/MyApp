package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import org.junit.Assert;
import org.junit.Test;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;

/**
 * Created by Basav Nagur.
 */

public class UserControllerTest extends WithApplication{



    @Test
    public void testListUsersRoute() {
        Result result = route(fakeRequest(GET, "/users/list"));
        assertNotNull(result);
        assertEquals(200,result.status());
    }

    @Test
    public void githubFindTest(){
        //make a request
        Result result = route(fakeRequest(GET, "/github/sam"));
        //assert that Result is not null
        assertNotNull(result);
        Assert.assertEquals("/users/list", result.redirectLocation());
    }

    @Test
    public void allUsersOnListPage(){
        //set up some data
        User user = new User();
        user.id = "100";
        user.login = "basav";
        Ebean.save(user);

        User user2 = new User();
        user2.id = "101";
        user2.login = "peter";
        Ebean.save(user2);

        //make a request
        Result result = route(fakeRequest(GET, "/users/list"));

        //assert that Result is not null
        assertNotNull(result);

        Assert.assertTrue(result.contentType().contains("text/html"));
        String content = contentAsString(result);

        Assert.assertTrue(content.contains("basav"));
        Assert.assertTrue(content.contains("peter"));
    }

}
