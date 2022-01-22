package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {
    private Controller twitterController;
    String hashTag = "#abc";
    String validtext = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();

    @Before
    public void setup() {
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        System.out.println(consumerKey + "|" + consumerSecret + "|" + accessToken);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        this.twitterController = new TwitterController((new TwitterService(new TwitterDao(httpHelper))));
    }

    @Test
    public void postTweet() {
        String[] args = {"null", validtext, "-1d:1d"};
        Tweet returnTweet = twitterController.postTweet(args);
        assertNotNull(returnTweet.getCoordinates());
        assertEquals(2, returnTweet.getCoordinates().getCoordinates().size());
    }

    @Test
    public void showTweet() {
        String[] postArgs = {"null", validtext, "-1d:1d"};
        Tweet returnPost = twitterController.postTweet(postArgs);
        String showId = returnPost.getIdStr();
        String[] args = {"null", showId, "id,coordinates"};
        Tweet tweet = twitterController.showTweet(args);
        assertNotNull(tweet.getCoordinates());
        assertNull(tweet.getEntities());
        assertEquals(2, tweet.getCoordinates().getCoordinates().size());
    }

    @Test
    public void deleteTweet() {
        String[] post1Args = {"null", validtext, "-1d:1d"};
        String[] post2Args = {"null", "anotha one", "-1d:1d"};

        Tweet returnPost1 = twitterController.postTweet(post1Args);
        Tweet returnPost2 = twitterController.postTweet(post2Args);
        String showId1 = returnPost1.getIdStr();
        String showId2 = returnPost2.getIdStr();
        List<Tweet> deleted = twitterController.deleteTweet(new String[]{showId1,showId2});
        assertEquals(showId1, deleted.get(0).getIdStr());
        assertEquals(showId2, deleted.get(1).getIdStr());

    }
}