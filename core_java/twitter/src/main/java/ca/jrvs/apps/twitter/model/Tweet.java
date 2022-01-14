package ca.jrvs.apps.twitter.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "createdAt",
        "id",
        "idStr",
        "text",
        "entities",
        "coordinates",
        "retweetCount",
        "favoriteCount",
        "favorited",
        "retweeted"
})

public class Tweet {

    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("idStr")
    private String idStr;
    @JsonProperty("text")
    private String text;
    @JsonProperty("entity")
    private Entities entity;
    @JsonProperty("coordinates")
    private Coordinates coordinates = null;
    @JsonProperty("retweetCount")
    private int retweetCount = 0;
    @JsonProperty("favoriteCount")
    private int favoriteCount = 0;
    @JsonProperty("favorited")
    private Boolean favorited = false;
    @JsonProperty("retweeted")
    private Boolean retweeted = false;

    public Tweet(String createdAt, Integer id, String idStr, String text, Entities entity, Coordinates coordinates, Integer retweetCount,
    Integer favoriteCount, boolean favorited, boolean retweeted) {
        this.createdAt = createdAt;
        this.id = id;
        this.idStr = idStr;
        this.text = text;
        this.entity = entity;
        this.coordinates = coordinates;
        this.retweetCount = retweetCount;
        this.favoriteCount = favoriteCount;
        this.favorited = favorited;
        this.retweeted = retweeted;
    }

    public Tweet(){
        //Create empty object
    }

    public String getcreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entities getEntity() {
        return entity;
    }

    public void setEntity(Entities entity) {
        this.entity = entity;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

}