package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;

import static org.junit.Assert.*;

public class TwitterHttpHelperTest {

    @Test
    public void httpPost() throws Exception {
        //String consumerKey = System.getenv("consumerKey");
        //String consumerSecret = System.getenv("consumerSecret");
        //String accessToken = System.getenv("accessToken");
        //String tokenSecret = System.getenv("tokenSecret");
        String consumerKey = "xgi3jfpp4iWmlqQ2fNf6X1aHo";
        String consumerSecret = "F7r8hOsvz1dueCoXOaNZFjbKpVrV7F5VMvJqRoi2uoaxeC425l";
        String accessToken = "3196537057-Ugyjh7eClcynJTX1hIs4rBw2rIhYQ1IxBqMGAV9";
        String tokenSecret = "lgTeu4l2JkChmiMKjC0hpuNypLcmXbRCRw3pBxS4NUbYI";
        System.out.println(consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        HttpResponse httpResponse = httpHelper.httpPost(new URI("https://api.twitter.com/1.1/statuses/update.json?status=java_testapi_POST"));
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }

    @Test
    public void httpGet() throws Exception {
        //String consumerKey = System.getenv("consumerKey");
        //String consumerSecret = System.getenv("consumerSecret");
        //String accessToken = System.getenv("accessToken");
        //String tokenSecret = System.getenv("tokenSecret");
        String consumerKey = "xgi3jfpp4iWmlqQ2fNf6X1aHo";
        String consumerSecret = "F7r8hOsvz1dueCoXOaNZFjbKpVrV7F5VMvJqRoi2uoaxeC425l";
        String accessToken = "3196537057-Ugyjh7eClcynJTX1hIs4rBw2rIhYQ1IxBqMGAV9";
        String tokenSecret = "lgTeu4l2JkChmiMKjC0hpuNypLcmXbRCRw3pBxS4NUbYI";
        System.out.println(consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);
        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        HttpResponse httpResponse = httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=sidfromsyd"));
        //System.out.println(httpResponse.getStatusLine().getStatusCode());
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }
}