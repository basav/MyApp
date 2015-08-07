package impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import models.User;
import play.Logger;
import play.libs.F;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import services.GithubService;

/**
 * Created by Basav Nagur.
 */
public class GithubServiceImpl implements GithubService {

    @Inject
    public WSClient ws;

    String baseUrl = "https://api.github.com";

    @Override
    public User find(String username) {
        F.Promise<WSResponse> response = ws.url(baseUrl + "/users/" + username).get();

        JsonNode jsonNode =  response.map(res -> res.asJson()).get(10000);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNK‌​NOWN_PROPERTIES);

        User user = null;
        try
        {
            user = mapper.treeToValue(jsonNode, User.class);
        } catch (JsonProcessingException e) {
            Logger.error("Error", e);
        }

        return user;
    }
}
