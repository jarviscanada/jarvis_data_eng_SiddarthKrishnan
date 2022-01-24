package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class TwitterDao implements CrdDao<Tweet, String> {
    //URL constants
    private static final String API_BASE_URI = "https://api.twitter.com";
    private static final String POST_PATH = "/1.1/statuses/update.json";
    private static final String SHOW_PATH = "/1.1/statuses/show.json";
    private static final String DELETE_PATH = "/1.1/statuses/destroy";
    //URI symbols
    private static final String QUERY_SYM = "?";
    private static final String EQUAL = "=";
    private static final String AMPERSAND = "&";
    //response code
    private static final int HTTP_OK = 200;

    private HttpHelper httpHelper;
/*    private String consumerKey = System.getenv("consumerKey");
    private String consumerSecret = System.getenv("consumerSecret");
    private String accessToken = System.getenv("accessToken");
    private String tokenSecret = System.getenv("tokenSecret");*/
    String consumerKey = "xgi3jfpp4iWmlqQ2fNf6X1aHo";
    String consumerSecret = "F7r8hOsvz1dueCoXOaNZFjbKpVrV7F5VMvJqRoi2uoaxeC425l";
    String accessToken = "3196537057-Ugyjh7eClcynJTX1hIs4rBw2rIhYQ1IxBqMGAV9";
    String tokenSecret = "lgTeu4l2JkChmiMKjC0hpuNypLcmXbRCRw3pBxS4NUbYI";

    @Autowired
    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }
    @Override
    public Tweet create(Tweet tweet) {
        URI uri;
        try {
            uri = getPostUri(tweet);

        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid input tweet", e);
        }
        HttpResponse httpResponse = httpHelper.httpPost(uri);
        return parseResponseBody(httpResponse, HTTP_OK);
    }

    Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode) {
        Tweet tweet = null;
        //Check response status
        int status = response.getStatusLine().getStatusCode();
        if (status != expectedStatusCode) {
            try {
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                System.out.println("Response has no entity");
            }
            throw new RuntimeException("unexpected HTTP status:" + status);
        }
        if (response.getEntity() == null) {
            throw new RuntimeException("empty response body");
        }
        //convert to JSON for tweet object
        String body;
        try {
            body = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException("Response has no entity");
        }
        try {
            tweet = JsonParser.toObjectFromJson(body, Tweet.class);
        } catch (IOException e) {
            throw new RuntimeException("unable to convert entity to Object", e);
        }
        return tweet;
    }

    private URI getPostUri(Tweet tweet) throws URISyntaxException {
        PercentEscaper percentEscaper = new PercentEscaper("", false);
        if(tweet.getCoordinates() != null) {
            double lat = tweet.getCoordinates().getCoordinates().get(1);
            double lon = tweet.getCoordinates().getCoordinates().get(0);
            return new URI(API_BASE_URI + POST_PATH + QUERY_SYM + "status" + EQUAL + percentEscaper.escape(tweet.getText()) +
                    AMPERSAND + "long" + EQUAL + lon + AMPERSAND + "lat" + EQUAL + lat);
        }
        return new URI(API_BASE_URI + POST_PATH + QUERY_SYM + "status" + EQUAL + percentEscaper.escape(tweet.getText()));
    }

    @Override
    public Tweet findById(String s) {
        HttpResponse response;
        HttpClient httpClient = HttpClientBuilder.create().build();
        OAuthConsumer consumer;
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);
        URI uri;
        try {
            uri = new URI(API_BASE_URI + SHOW_PATH + QUERY_SYM + "id" + EQUAL + s);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid input", e);
        }
        response = httpHelper.httpGet(uri);
        return parseResponseBody(response, HTTP_OK);
    }

    @Override
    public Tweet deleteById(String s) {
        HttpResponse response;
        URI uri;
        try {
            uri = new URI(API_BASE_URI + DELETE_PATH + "/" + s + ".json");
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid input", e);
        }
        response = httpHelper.httpPost(uri);
        return parseResponseBody(response, HTTP_OK);
    }

}
