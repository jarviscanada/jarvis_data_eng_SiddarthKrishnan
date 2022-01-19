package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceIntTest {
    private TwitterService twitterService;
    String hashTag = "#abc";
    String validtext = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();
    Tweet validtweet = TweetUtil.buildTweet(validtext, -1d, 1d);

    @Before
    public void setup() {
        //String consumerKey = System.getenv("consumerKey");
        //String consumerSecret = System.getenv("consumerSecret");
        //String accessToken = System.getenv("accessToken");
        //String tokenSecret = System.getenv("tokenSecret");
        String consumerKey = "xgi3jfpp4iWmlqQ2fNf6X1aHo";
        String consumerSecret = "F7r8hOsvz1dueCoXOaNZFjbKpVrV7F5VMvJqRoi2uoaxeC425l";
        String accessToken = "3196537057-Ugyjh7eClcynJTX1hIs4rBw2rIhYQ1IxBqMGAV9";
        String tokenSecret = "lgTeu4l2JkChmiMKjC0hpuNypLcmXbRCRw3pBxS4NUbYI";
        System.out.println(consumerKey + "|" + consumerSecret + "|" + accessToken);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        this.twitterService = new TwitterService((new TwitterDao(httpHelper)));
    }

    @Test
    public void postTweet() {
        String invalidtext = "THIS IS AN EXTRA LONG TWEET EXCEEDING 140 CHARACTERS TO TEST OUR TWITTER SERVICE" +
                "FUNCTIONALITY. BLAHBLAHBLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH" +
                "BLAH BLAH BLAH";
        Double lat= 1d;
        Double lon = -1d;
        Tweet invalidtweet1 = TweetUtil.buildTweet(invalidtext, lon, lat);
        Tweet invalidtweet2 = TweetUtil.buildTweet(validtext, 190d, 1d);
        Tweet invalidtweet3 = TweetUtil.buildTweet(validtext, 1d, -95d);
        try {
            Tweet postTweet = twitterService.postTweet(invalidtweet1);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            Tweet postTweet = twitterService.postTweet(invalidtweet2);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            Tweet postTweet = twitterService.postTweet(invalidtweet3);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        Tweet returnTweet = twitterService.postTweet(validtweet);
        assertNotNull(returnTweet.getCoordinates());
        assertEquals(2, returnTweet.getCoordinates().getCoordinates().size());
    }

    @Test
    public void showTweet() {
        Tweet postedTweet = twitterService.postTweet(validtweet);
        String id = postedTweet.getIdStr();
        Tweet shownTweet = twitterService.showTweet(id, new String[]{"created_at", "text"});
        assertNotNull(shownTweet.getCreatedAt());
        assertNotNull(shownTweet.getText());
        assertNull(shownTweet.getCoordinates());
    }

    @Test
    public void deleteTweets() {
        Tweet postedTweet1 = twitterService.postTweet(validtweet);
        String msg = "@sidfromsyd junit test running a second time" + hashTag + " " + System.currentTimeMillis();
        Tweet diffTweet = TweetUtil.buildTweet(msg, -45d, 45d);
        Tweet postedTweet2 = twitterService.postTweet(diffTweet);
        List<Tweet> deleted = twitterService.deleteTweets(new String[]{
                postedTweet1.getIdStr(), postedTweet2.getIdStr()});
        assertEquals(postedTweet1.getIdStr(), (deleted.get(0).getIdStr()));
        assertEquals(postedTweet2.getIdStr(), (deleted.get(1).getIdStr()));
    }
}