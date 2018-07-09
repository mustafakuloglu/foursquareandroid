package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Reasons{
  @SerializedName("count")
  @Expose
  private Integer count;
  @SerializedName("items")
  @Expose
  private List<Items> items;
  public void setCount(Integer count){
   this.count=count;
  }
  public Integer getCount(){
   return count;
  }
  public void setItems(List<Items> items){
   this.items=items;
  }
  public List<Items> getItems(){
   return items;
  }
}