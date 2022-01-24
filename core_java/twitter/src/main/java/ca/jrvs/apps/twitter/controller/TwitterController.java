package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public class TwitterController implements Controller {
    private static final String COORD_SEP = ":";
    private static final String COMMA = ",";

    private Service service;

    @Autowired
    public TwitterController(Service service) {
        this.service = service;
    }

    @Override
    public Tweet postTweet(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE:");
        }
        String tweet_text = args[1];
        String coords = args[2];
        String [] coordSplit = coords.split(COORD_SEP);
        if (coordSplit.length != 2 || StringUtils.isEmpty(tweet_text)) {
            throw new IllegalArgumentException("Invalid arugment format \n " +
                    "arguments: \"post\" \"text\" \"longitutde:latitude\"");
        }
        Double lat = null;
        Double lon = null;
        try {
            lon = Double.parseDouble(coordSplit[0]);
            lat = Double.parseDouble(coordSplit[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("bad location format", e);
        }
        Tweet tweet = TweetUtil.buildTweet(tweet_text, lon, lat);
        return service.postTweet(tweet);
    }

    @Override
    public Tweet showTweet(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE:");
        }
        String id = args[1];
        String [] fields = args[2].split(COMMA);
        if (StringUtils.isEmpty((id)) || StringUtils.isEmpty(args[2])) {
            throw new IllegalArgumentException("Invalid arugment format \n " +
                    "arguments: \"show\" \"tweetid\" \"field1,field2,etc\"");
        }
        return service.showTweet(id, fields);
    }

    @Override
    public List<Tweet> deleteTweet(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("USAGE: " +
                    "arguments: \"delete\" \"id1,id2,...\"");
        }
        for (String i: args) {
            if(StringUtils.isEmpty(i)) {
                throw new IllegalArgumentException("Invalid arugment format \n " +
                        "arguments: \"delete\" \"id,id\" ");
            }
        }
        return service.deleteTweets(args);
    }
}
