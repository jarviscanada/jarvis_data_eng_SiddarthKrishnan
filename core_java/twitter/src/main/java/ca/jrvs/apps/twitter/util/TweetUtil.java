package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;

import java.util.Arrays;


public class TweetUtil {
    public static Tweet buildTweet(String text, Double lon, Double lat) {
        Tweet tweet = new Tweet();
        //Coordinates coordinates = new Coordinates(Arrays.asList(lon, lat));
        Coordinates coordinates = new Coordinates();
        coordinates.setCoordinates(Arrays.asList(lon, lat));
        tweet.setCoordinates(coordinates);
        tweet.setText(text);
        tweet.setCoordinates(coordinates);
        return tweet;
    }
    public static Tweet buildTweet(String text) {
            Tweet tweet = new Tweet();
            tweet.setText(text);
            return tweet;
    }
}
