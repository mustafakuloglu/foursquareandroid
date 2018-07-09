package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class LabeledLatLngs{
  @SerializedName("lng")
  @Expose
  private Double lng;
  @SerializedName("label")
  @Expose
  private String label;
  @SerializedName("lat")
  @Expose
  private Double lat;
  public void setLng(Double lng){
   this.lng=lng;
  }
  public Double getLng(){
   return lng;
  }
  public void setLabel(String label){
   this.label=label;
  }
  public String getLabel(){
   return label;
  }
  public void setLat(Double lat){
   this.lat=lat;
  }
  public Double getLat(){
   return lat;
  }
}