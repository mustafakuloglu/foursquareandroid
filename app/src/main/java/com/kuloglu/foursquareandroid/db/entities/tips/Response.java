package com.kuloglu.foursquareandroid.db.entities.tips;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Awesome Pojo Generator
 */
public class Response {
    @SerializedName("tips")
    @Expose
    private Tips tips;

    public Tips getTips() {
        return tips;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }
}