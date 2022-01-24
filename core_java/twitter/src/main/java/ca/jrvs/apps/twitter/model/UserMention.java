package ca.jrvs.apps.twitter.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMention {

    @JsonProperty("name")
    private String name;
    @JsonProperty("indices")
    private List<Integer> indices;
    @JsonProperty("screen_name")
    private String screen_name;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("id_str")
    private String id_str;


/*    public UserMention(String name, List<Integer> indices, String screenName, Long id, String idStr){
        this.name = name;
        this.indices = indices;
        this.screenName = screenName;
        this.id = id;
        this.idStr = idStr;
    }*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getScreenName() {
        return screen_name;
    }

    public void setScreenName(String screenName) {
        this.screen_name = screenName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return id_str;
    }

    public void setIdStr(String idStr) {
        this.id_str = idStr;
    }

}