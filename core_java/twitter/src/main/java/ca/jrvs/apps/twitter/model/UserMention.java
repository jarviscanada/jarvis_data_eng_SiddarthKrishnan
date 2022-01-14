package ca.jrvs.apps.twitter.model;

import java.util.List;

public class UserMention {


    private String name;
    private List<Integer> indices;
    private String screenName;
    private Integer id;
    private String idStr;


    public UserMention(String name, List<Integer> indices, String screenName, Integer id, String idStr){
        this.name = name;
        this.indices = indices;
        this.screenName = screenName;
        this.id = id;
        this.idStr = idStr;
    }


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
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
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

}