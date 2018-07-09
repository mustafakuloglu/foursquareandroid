package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class SuggestedBounds{
  @SerializedName("sw")
  @Expose
  private Sw sw;
  @SerializedName("ne")
  @Expose
  private Ne ne;
  public void setSw(Sw sw){
   this.sw=sw;
  }
  public Sw getSw(){
   return sw;
  }
  public void setNe(Ne ne){
   this.ne=ne;
  }
  public Ne getNe(){
   return ne;
  }
}