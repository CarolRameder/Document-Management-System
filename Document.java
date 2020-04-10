package com.company;

import java.io.Serializable;
import java.net.URI;
import java.util.TreeMap;

public class Document implements Serializable {
    private int ID;
    private String name;
    private String type;
    private String link;
    private TreeMap<String,String > tags = new TreeMap();

    public int getID() {
        return ID;
    }

    public TreeMap<String, String> getTags() {
        return tags;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public URI getLink() {
        return URI.create(link);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Document(int ID, String name,String link) {
        this.ID = ID;
        this.name = name;
        this.link=link;
    }

    public Document() {
    }

    public void addTag(String tagName, String tagValue){
        tags.put(tagName,tagValue);
    }
}
