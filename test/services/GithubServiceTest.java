package services;

import impl.GithubServiceImpl;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import play.api.routing.Router;
import play.libs.ws.WS;
import play.libs.ws.WSClient;
import play.routing.RoutingDsl;
import play.server.Server;

import static play.mvc.Results.ok;

/**
 * Created by Basav Nagur.
 */
public class GithubServiceTest {

    WSClient ws;
    Server server;
    GithubServiceImpl githubService;

    @Before
    public void setup() {
        Router router = new RoutingDsl()
                .GET("/users/basav").routeTo(() ->
                                ok().sendResource("github/basav.json")
                )
                .build();

        server = Server.forRouter(router);
        ws = WS.newClient(server.httpPort());
        githubService = new GithubServiceImpl();
        githubService.ws = ws;
    }

    @After
    public void tearDown() {
        ws.close();
        server.stop();
    }

    @Test
    public void githubAPITest() {
        String username = "basav";
        User user = githubService.find(username);
        Assert.assertNotNull(user);
        Assert.assertEquals("basav",user.login);
    }

}