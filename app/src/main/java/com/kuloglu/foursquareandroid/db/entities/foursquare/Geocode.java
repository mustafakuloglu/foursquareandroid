package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Geocode{
  @SerializedName("cc")
  @Expose
  private String cc;
  @SerializedName("what")
  @Expose
  private String what;
  @SerializedName("displayString")
  @Expose
  private String displayString;
  @SerializedName("center")
  @Expose
  private Center center;
  @SerializedName("where")
  @Expose
  private String where;
  @SerializedName("longId")
  @Expose
  private Long longId;
  public void setCc(String cc){
   this.cc=cc;
  }
  public String getCc(){
   return cc;
  }
  public void setWhat(String what){
   this.what=what;
  }
  public String getWhat(){
   return what;
  }
  public void setDisplayString(String displayString){
   this.displayString=displayString;
  }
  public String getDisplayString(){
   return displayString;
  }
  public void setCenter(Center center){
   this.center=center;
  }
  public Center getCenter(){
   return center;
  }
  public void setWhere(String where){
   this.where=where;
  }
  public String getWhere(){
   return where;
  }
  public void setLongId(Long longId){
   this.longId=longId;
  }
  public Long getLongId(){
   return longId;
  }
}