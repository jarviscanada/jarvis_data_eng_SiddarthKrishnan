package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {
    private Controller twitterController;
    String hashTag = "#abc";
    String validtext = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();

    @Before
    public void setup() {
        String consumerKey = "xgi3jfpp4iWmlqQ2fNf6X1aHo";
        String consumerSecret = "F7r8hOsvz1dueCoXOaNZFjbKpVrV7F5VMvJqRoi2uoaxeC425l";
        String accessToken = "3196537057-Ugyjh7eClcynJTX1hIs4rBw2rIhYQ1IxBqMGAV9";
        String tokenSecret = "lgTeu4l2JkChmiMKjC0hpuNypLcmXbRCRw3pBxS4NUbYI";
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
    }

    @Test
    public void deleteTweet() {
    }
}