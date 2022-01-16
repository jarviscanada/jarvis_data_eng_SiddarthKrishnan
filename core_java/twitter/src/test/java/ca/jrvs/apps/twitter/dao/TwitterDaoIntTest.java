package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
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
    public void create() {
        String hashTag = "#abc";
        String text = "@sidfromsyd sometext " + hashTag + " " + System.currentTimeMillis();
        Double lat= 1d;
        Double lon = -1d;
        Tweet postTweet = TwitterDao.TweetUtil.buildTweet(text, lon, lat);
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
    }
}