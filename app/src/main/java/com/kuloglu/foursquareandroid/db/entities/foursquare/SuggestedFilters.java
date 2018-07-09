package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class SuggestedFilters{
  @SerializedName("header")
  @Expose
  private String header;
  @SerializedName("filters")
  @Expose
  private List<Filters> filters;
  public void setHeader(String header){
   this.header=header;
  }
  public String getHeader(){
   return header;
  }
  public void setFilters(List<Filters> filters){
   this.filters=filters;
  }
  public List<Filters> getFilters(){
   return filters;
  }
}