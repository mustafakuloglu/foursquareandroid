package com.kuloglu.foursquareandroid.db.entities.tips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kuloglu.foursquareandroid.db.entities.foursquare.Groups;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class Likes {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("groups")
    @Expose
    private List<Groups> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}