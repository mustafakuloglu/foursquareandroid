package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Photos{
  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("groups")
  @Expose
  private List<Groups> groups;
  public void setCount(Integer count){
   this.count=count;
  }
  public Integer getCount(){
   return count;
  }
  public void setGroups(List<Groups> groups){
   this.groups=groups;
  }
  public List<Groups> getGroups(){
   return groups;
  }
}