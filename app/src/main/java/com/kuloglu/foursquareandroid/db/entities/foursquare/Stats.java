package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Stats{
  @SerializedName("visitsCount")
  @Expose
  private Integer visitsCount;
  @SerializedName("checkinsCount")
  @Expose
  private Integer checkinsCount;
  @SerializedName("usersCount")
  @Expose
  private Integer usersCount;
  @SerializedName("tipCount")
  @Expose
  private Integer tipCount;
  public void setVisitsCount(Integer visitsCount){
   this.visitsCount=visitsCount;
  }
  public Integer getVisitsCount(){
   return visitsCount;
  }
  public void setCheckinsCount(Integer checkinsCount){
   this.checkinsCount=checkinsCount;
  }
  public Integer getCheckinsCount(){
   return checkinsCount;
  }
  public void setUsersCount(Integer usersCount){
   this.usersCount=usersCount;
  }
  public Integer getUsersCount(){
   return usersCount;
  }
  public void setTipCount(Integer tipCount){
   this.tipCount=tipCount;
  }
  public Integer getTipCount(){
   return tipCount;
  }
}