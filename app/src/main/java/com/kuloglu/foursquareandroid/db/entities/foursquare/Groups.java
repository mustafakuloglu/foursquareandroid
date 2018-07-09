package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Groups{
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("items")
  @Expose
  private List<Items> items;
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setType(String type){
   this.type=type;
  }
  public String getType(){
   return type;
  }
  public void setItems(List<Items> items){
   this.items=items;
  }
  public List<Items> getItems(){
   return items;
  }
}