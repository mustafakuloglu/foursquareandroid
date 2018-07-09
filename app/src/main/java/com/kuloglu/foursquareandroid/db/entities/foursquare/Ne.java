package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Ne{
  @SerializedName("lng")
  @Expose
  private Double lng;
  @SerializedName("lat")
  @Expose
  private Double lat;
  public void setLng(Double lng){
   this.lng=lng;
  }
  public Double getLng(){
   return lng;
  }
  public void setLat(Double lat){
   this.lat=lat;
  }
  public Double getLat(){
   return lat;
  }
}