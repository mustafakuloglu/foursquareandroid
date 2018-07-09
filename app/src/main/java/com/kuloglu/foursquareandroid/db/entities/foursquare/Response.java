package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Response{
  @SerializedName("suggestedFilters")
  @Expose
  private SuggestedFilters suggestedFilters;
  @SerializedName("totalResults")
  @Expose
  private Integer totalResults;
  @SerializedName("geocode")
  @Expose
  private Geocode geocode;
  @SerializedName("headerFullLocation")
  @Expose
  private String headerFullLocation;
  @SerializedName("headerLocationGranularity")
  @Expose
  private String headerLocationGranularity;
  @SerializedName("groups")
  @Expose
  private List<Groups> groups;
  @SerializedName("suggestedBounds")
  @Expose
  private SuggestedBounds suggestedBounds;
  @SerializedName("headerLocation")
  @Expose
  private String headerLocation;
  public void setSuggestedFilters(SuggestedFilters suggestedFilters){
   this.suggestedFilters=suggestedFilters;
  }
  public SuggestedFilters getSuggestedFilters(){
   return suggestedFilters;
  }
  public void setTotalResults(Integer totalResults){
   this.totalResults=totalResults;
  }
  public Integer getTotalResults(){
   return totalResults;
  }
  public void setGeocode(Geocode geocode){
   this.geocode=geocode;
  }
  public Geocode getGeocode(){
   return geocode;
  }
  public void setHeaderFullLocation(String headerFullLocation){
   this.headerFullLocation=headerFullLocation;
  }
  public String getHeaderFullLocation(){
   return headerFullLocation;
  }
  public void setHeaderLocationGranularity(String headerLocationGranularity){
   this.headerLocationGranularity=headerLocationGranularity;
  }
  public String getHeaderLocationGranularity(){
   return headerLocationGranularity;
  }
  public void setGroups(List<Groups> groups){
   this.groups=groups;
  }
  public List<Groups> getGroups(){
   return groups;
  }
  public void setSuggestedBounds(SuggestedBounds suggestedBounds){
   this.suggestedBounds=suggestedBounds;
  }
  public SuggestedBounds getSuggestedBounds(){
   return suggestedBounds;
  }
  public void setHeaderLocation(String headerLocation){
   this.headerLocation=headerLocation;
  }
  public String getHeaderLocation(){
   return headerLocation;
  }
}