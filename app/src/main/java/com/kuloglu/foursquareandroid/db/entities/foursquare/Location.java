package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Location{
  @SerializedName("cc")
  @Expose
  private String cc;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("address")
  @Expose
  private String address;
  @SerializedName("labeledLatLngs")
  @Expose
  private List<LabeledLatLngs> labeledLatLngs;
  @SerializedName("lng")
  @Expose
  private Double lng;
  @SerializedName("formattedAddress")
  @Expose
  private List<String> formattedAddress;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("state")
  @Expose
  private String state;
  @SerializedName("crossStreet")
  @Expose
  private String crossStreet;
  @SerializedName("lat")
  @Expose
  private Double lat;
  public void setCc(String cc){
   this.cc=cc;
  }
  public String getCc(){
   return cc;
  }
  public void setCountry(String country){
   this.country=country;
  }
  public String getCountry(){
   return country;
  }
  public void setAddress(String address){
   this.address=address;
  }
  public String getAddress(){
   return address;
  }
  public void setLabeledLatLngs(List<LabeledLatLngs> labeledLatLngs){
   this.labeledLatLngs=labeledLatLngs;
  }
  public List<LabeledLatLngs> getLabeledLatLngs(){
   return labeledLatLngs;
  }
  public void setLng(Double lng){
   this.lng=lng;
  }
  public Double getLng(){
   return lng;
  }
  public void setFormattedAddress(List<String> formattedAddress){
   this.formattedAddress=formattedAddress;
  }
  public Object getFormattedAddress(){
   return formattedAddress;
  }
  public void setCity(String city){
   this.city=city;
  }
  public String getCity(){
   return city;
  }
  public void setState(String state){
   this.state=state;
  }
  public String getState(){
   return state;
  }
  public void setCrossStreet(String crossStreet){
   this.crossStreet=crossStreet;
  }
  public String getCrossStreet(){
   return crossStreet;
  }
  public void setLat(Double lat){
   this.lat=lat;
  }
  public Double getLat(){
   return lat;
  }
}