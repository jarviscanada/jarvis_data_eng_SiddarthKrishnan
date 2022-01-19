package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {
    String hashTag = "#abc";
    String validText = "@sidfromsyd junit test running " + hashTag + " " + System.currentTimeMillis();
    Tweet validTweet = TweetUtil.buildTweet(validText, -1d, 1d);

    String tweetJsonStr = "{\n"
            + "   \"created_at\":\"Mon Jan 17 21:24:39 +0000 2022\",\n"
            + "   \"id\":1097607853932564480,\n"
            + "   \"id_str\":\"1097607853932564480\",\n"
            + "   \"text\":\"test with loc223\",\n"
            + "   \"entities\":{\n"
            + "      \"hashtags\":[],"
            + "      \"user_mentions\":[]"
            + "   },\n"
            + "   \"coordinates\":null,"
            + "   \"retweet_count\":0,\n"
            + "   \"favorite_count\":0,\n"
            + "   \"favorited\":false,\n"
            + "   \"retweeted\":false\n"
            + "}";
    @Mock
    CrdDao dao;

    @InjectMocks
    TwitterService service;

    @Test
    public void postTweet() {
        String invalidtext = "THIS IS AN EXTRA LONG TWEET EXCEEDING 140 CHARACTERS TO TEST OUR TWITTER SERVICE" +
                "FUNCTIONALITY. BLAHBLAHBLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH" +
                "BLAH BLAH BLAH";
        when(dao.create((any()))).thenReturn(new Tweet());
        service.postTweet(TweetUtil.buildTweet("test", 50.0, 0.0));
        try {
            service.postTweet(TweetUtil.buildTweet(invalidtext, 50.0, 0.0));
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            service.postTweet(TweetUtil.buildTweet("test", -190.0, 0.0));
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            service.postTweet(TweetUtil.buildTweet("test", 1.0, 91.0));
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void showTweet() throws IOException {
        Tweet ourTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        when(dao.findById("1097607853932564480")).thenReturn(ourTweet);
        Service servicex = Mockito.spy(service);
        Tweet shownTweet = servicex.showTweet("1097607853932564480", new String[]{"created_at", "text", "id_str"});
        assertEquals(ourTweet.getIdStr(), shownTweet.getIdStr());
        assertNull(shownTweet.getId());
    }

    @Test
    public void deleteTweets() throws IOException {
        Tweet ourTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        when(dao.deleteById("1097607853932564480")).thenReturn(ourTweet);
        Service servicex = Mockito.spy(service);
        List<Tweet> deleted = servicex.deleteTweets(new String[] {"1097607853932564480"});
        assertEquals(ourTweet.getText(), (deleted.get(0).getText()));
        assertEquals(ourTweet.getIdStr(), (deleted.get(1).getIdStr()));
    }
}