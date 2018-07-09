package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class BeenHere{
  @SerializedName("marked")
  @Expose
  private Boolean marked;
  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("lastCheckinExpiredAt")
  @Expose
  private Integer lastCheckinExpiredAt;
  @SerializedName("unconfirmedCount")
  @Expose
  private Integer unconfirmedCount;
  public void setMarked(Boolean marked){
   this.marked=marked;
  }
  public Boolean getMarked(){
   return marked;
  }
  public void setCount(Integer count){
   this.count=count;
  }
  public Integer getCount(){
   return count;
  }
  public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt){
   this.lastCheckinExpiredAt=lastCheckinExpiredAt;
  }
  public Integer getLastCheckinExpiredAt(){
   return lastCheckinExpiredAt;
  }
  public void setUnconfirmedCount(Integer unconfirmedCount){
   this.unconfirmedCount=unconfirmedCount;
  }
  public Integer getUnconfirmedCount(){
   return unconfirmedCount;
  }
}