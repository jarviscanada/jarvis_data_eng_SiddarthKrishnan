package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {
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
    Service twitterService;

    @InjectMocks
    TwitterController controller;

    @Test
    public void postTweet() {
        Tweet tweet = null;
        try {
            tweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        when(twitterService.postTweet(any())).thenReturn(tweet);
        Tweet returnedTweet = controller.postTweet(new String[]{"null","test with loc223","1.0:-1.0"});
        assertNotNull(returnedTweet);
        try {
            tweet = controller.postTweet(new String[]{"null","text"});
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            tweet = controller.postTweet(new String[]{"null","text","1d"});
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void showTweet() {
        Tweet tweet = null;
        try {
            tweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        when(twitterService.showTweet(any(), any())).thenReturn(tweet);
        Tweet returnedTweet = controller.showTweet(new String[]{"null", "1097607853932564480", "id,coordinates"});
        try {
            tweet = controller.showTweet(new String[]{"null","12213432432534"});
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
        try {
            tweet = controller.showTweet(new String[]{"null","1221423414",""});
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteTweet() {
        Tweet tweet = null;
        try {
            tweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[]x = new String[]{"1097607853932564480"};
        //when(twitterService.deleteTweets(any())).thenReturn(x));
        doReturn(x).when(twitterService.deleteTweets(any()));
        List<Tweet> deleted = controller.deleteTweet(new String[]{"null", "1097607853932564480"});

    }
}