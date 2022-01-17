package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.minidev.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwitterDaoIntTest {
    private TwitterDao dao;

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
        this.dao = new TwitterDao(httpHelper);
    }

    @Test
    public void create() throws Exception {
        String hashTag = "#abc";
        String text = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();
        Double lat= 1d;
        Double lon = -1d;
        Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
        Tweet tweet = dao.create(postTweet);
        assertEquals(text, tweet.getText());

        assertNotNull(tweet.getCoordinates());
        assertEquals(2, tweet.getCoordinates().getCoordinates().size());
        assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));

        assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
    }

    @Test
    public void findById() {
        String hashTag = "#abc";
        String text = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();
        Tweet postTweet = TweetUtil.buildTweet(text);
        Tweet tweet = dao.create(postTweet);
        String id = tweet.getIdStr();
        Tweet findTweet = dao.findById(id);
        assertEquals(tweet.getIdStr(), findTweet.getIdStr());

    }

    @Test
    public void deleteById() {
        String hashTag = "#abc";
        String text = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();
        Tweet postTweet = TweetUtil.buildTweet(text);
        Tweet tweet = dao.create(postTweet);
        String id = tweet.getIdStr();
        Tweet deletedTweet = dao.deleteById(id);
        assertEquals(tweet.getIdStr(), deletedTweet.getIdStr());

    }
}