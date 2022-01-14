package ca.jrvs.apps.twitter.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entities {
    private List<HashTag> hashTags;
    private List<UserMention> userMentions;

    public Entities(List<HashTag> hashtags, List<UserMention> usermetions) {
        this.hashTags = hashtags;
        this.userMentions=usermetions;
    }

    public List<HashTag> getHasTags() {
        return hashTags;
    }

    public void setHashTags(List<HashTag> hashtags) {
        this.hashTags = hashtags;
    }


    public List<UserMention> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<UserMention> userMentions) {
        this.userMentions = userMentions;
    }
}

