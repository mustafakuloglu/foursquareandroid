package com.kuloglu.foursquareandroid.db.entities.foursquare;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class Venue{
  @SerializedName("hereNow")
  @Expose
  private HereNow hereNow;
  @SerializedName("stats")
  @Expose
  private Stats stats;
  @SerializedName("contact")
  @Expose
  private Contact contact;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("verified")
  @Expose
  private Boolean verified;
  @SerializedName("location")
  @Expose
  private Location location;
  @SerializedName("id")
  @Expose
  private String id;
  @SerializedName("categories")
  @Expose
  private List<Categories> categories;
  @SerializedName("photos")
  @Expose
  private Photos photos;
  @SerializedName("beenHere")
  @Expose
  private BeenHere beenHere;
  public void setHereNow(HereNow hereNow){
   this.hereNow=hereNow;
  }
  public HereNow getHereNow(){
   return hereNow;
  }
  public void setStats(Stats stats){
   this.stats=stats;
  }
  public Stats getStats(){
   return stats;
  }
  public void setContact(Contact contact){
   this.contact=contact;
  }
  public Contact getContact(){
   return contact;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
  public void setVerified(Boolean verified){
   this.verified=verified;
  }
  public Boolean getVerified(){
   return verified;
  }
  public void setLocation(Location location){
   this.location=location;
  }
  public Location getLocation(){
   return location;
  }
  public void setId(String id){
   this.id=id;
  }
  public String getId(){
   return id;
  }
  public void setCategories(List<Categories> categories){
   this.categories=categories;
  }
  public List<Categories> getCategories(){
   return categories;
  }
  public void setPhotos(Photos photos){
   this.photos=photos;
  }
  public Photos getPhotos(){
   return photos;
  }
  public void setBeenHere(BeenHere beenHere){
   this.beenHere=beenHere;
  }
  public BeenHere getBeenHere(){
   return beenHere;
  }
}