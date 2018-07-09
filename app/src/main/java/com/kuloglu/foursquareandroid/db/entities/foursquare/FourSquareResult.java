package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class FourSquareResult{
  @SerializedName("meta")
  @Expose
  private Meta meta;
  @SerializedName("response")
  @Expose
  private Response response;
  public void setMeta(Meta meta){
   this.meta=meta;
  }
  public Meta getMeta(){
   return meta;
  }
  public void setResponse(Response response){
   this.response=response;
  }
  public Response getResponse(){
   return response;
  }
}