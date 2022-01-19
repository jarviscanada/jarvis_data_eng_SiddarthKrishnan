package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.util.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwitterService implements Service {

    private CrdDao dao;

    public TwitterService(CrdDao dao) {
        this.dao = dao;
    }

    @Override
    public Tweet postTweet(Tweet tweet) {
        validatePostTweet(tweet);
        return (Tweet) dao.create(tweet);
    }

    private void validatePostTweet(Tweet tweet) {
        //length < 140 and lon + lat in range
        Double lon = tweet.getCoordinates().getCoordinates().get(0);
        Double lat = tweet.getCoordinates().getCoordinates().get(1);
        if (tweet.getText().length() > 140) {
            throw new IllegalArgumentException("exceeding character limit");
        }
        if (180 < lon || lon < -180 || lat < -90 || lat > 90) {
            throw new IllegalArgumentException("long or lat out of range");
        }
    }

    @Override
    public Tweet showTweet(String id, String[] fields) {
        if (!id.matches("[0-9]+")) {
            throw new IllegalArgumentException("invalid tweet id");
        }
        Tweet shownTweet = (Tweet) dao.findById(id);
        String tweetString = null;
        Tweet returnTweet = new Tweet();
        try {
            tweetString = JsonParser.toJson(shownTweet, false, false);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode=null;
        try {
            rootNode = mapper.readTree(tweetString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = null;
        for (Iterator<Map.Entry<String, JsonNode>> it = rootNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> jsonField = it.next();
            String currentField = jsonField.getKey();

            if(!Arrays.asList(fields).contains(currentField)) {
                ((ObjectNode) rootNode).replace(currentField, null);
            }
        }
        try {
            return mapper.treeToValue(rootNode, Tweet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("can't return Tweet object");
        }
    }

    @Override
    public List<Tweet> deleteTweets(String[] ids) {
        for (String id: ids) {
            if (!id.matches("[0-9]+")) {
                throw new IllegalArgumentException("invalid tweet id");
            }
        }
        return Arrays.stream(ids).map(id -> (Tweet) dao.deleteById(id)).collect(Collectors.toList());
    }

}
