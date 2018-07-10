package com.kuloglu.foursquareandroid.db.entities.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Awesome Pojo Generator
 */
public class Items {
    @SerializedName("createdAt")
    @Expose
    private Integer createdAt;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}