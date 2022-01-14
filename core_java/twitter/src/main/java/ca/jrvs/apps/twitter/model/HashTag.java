package ca.jrvs.apps.twitter.model;

import java.util.List;

public class HashTag {
    private List<Integer> indices;
    private String text;

    public HashTag(List<Integer> indices, String text) {
        this.indices = indices;
        this.text = text;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
