package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Meta{
  @SerializedName("code")
  @Expose
  private Integer code;
  @SerializedName("requestId")
  @Expose
  private String requestId;
  public void setCode(Integer code){
   this.code=code;
  }
  public Integer getCode(){
   return code;
  }
  public void setRequestId(String requestId){
   this.requestId=requestId;
  }
  public String getRequestId(){
   return requestId;
  }
}