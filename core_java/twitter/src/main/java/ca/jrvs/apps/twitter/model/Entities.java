package ca.jrvs.apps.twitter.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {
    @JsonProperty("hashtags")
    private List<Hashtag> hashtags;
    @JsonProperty("user_mentions")
    private List<UserMention> user_mentions;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashTags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<UserMention> getUserMentions() {
        return user_mentions;
    }

    public void setUserMentions(List<UserMention> userMentions) {
        this.user_mentions = userMentions;
    }
}

