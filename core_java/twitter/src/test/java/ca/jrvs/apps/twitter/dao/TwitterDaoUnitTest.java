package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterDaoUnitTest {
    @Mock
    List<String> mockedList;

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
    HttpHelper mockHelper;

    @InjectMocks
    TwitterDao dao;

    @Test
    public void showTweet() throws Exception {
        //test failed request
        String hashTag = "#abc";
        String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
        Double lat = 1d;
        Double lon = -1d;
        //exception expected here
        when(mockHelper.httpPost(isNotNull())).thenThrow(new RuntimeException("mock"));
        try{
            dao.create(TweetUtil.buildTweet(text, lon, lat));
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }
        when(mockHelper.httpPost(isNotNull())).thenReturn(null);
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        //mock parseResponseBody
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.create(TweetUtil.buildTweet(text, lon, lat));
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }

    @Test
    public void postTweet() throws Exception {
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.create(expectedTweet);
        assertNotNull(tweet.getText());
    }

    @Test
    public void deleteTweet() throws Exception {
        String id_string = "1097607853932564480";
        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJsonStr, Tweet.class);
        doReturn(expectedTweet).when(spyDao).parseResponseBody(any(), anyInt());
        Tweet tweet = spyDao.deleteById(id_string);
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }
}