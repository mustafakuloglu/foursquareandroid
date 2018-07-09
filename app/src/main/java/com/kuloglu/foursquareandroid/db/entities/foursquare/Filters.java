package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Filters{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("key")
  @Expose
  private String key;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setKey(String key){
   this.key=key;
  }
  public String getKey(){
   return key;
  }
}