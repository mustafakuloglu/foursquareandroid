package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Items{
  @SerializedName("venue")
  @Expose
  private Venue venue;
  @SerializedName("reasons")
  @Expose
  private Reasons reasons;
  @SerializedName("referralId")
  @Expose
  private String referralId;
  public void setVenue(Venue venue){
   this.venue=venue;
  }
  public Venue getVenue(){
   return venue;
  }
  public void setReasons(Reasons reasons){
   this.reasons=reasons;
  }
  public Reasons getReasons(){
   return reasons;
  }
  public void setReferralId(String referralId){
   this.referralId=referralId;
  }
  public String getReferralId(){
   return referralId;
  }
}