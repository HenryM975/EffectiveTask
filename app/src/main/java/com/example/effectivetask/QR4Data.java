package com.example.effectivetask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CPU",
        "camera",
        "capacity",
        "color",
        "id",
        "images",
        "isFavorites",
        "price",
        "rating",
        "sd",
        "ssd",
        "title"
})
@Generated("jsonschema2pojo")
public class QR4Data {

    @JsonProperty("CPU")
    private String cpu;
    @JsonProperty("camera")
    private String camera;
    @JsonProperty("capacity")
    private List<String> capacity = null;
    @JsonProperty("color")
    private List<String> color = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<String> images = null;
    @JsonProperty("isFavorites")
    private boolean isFavorites;
    @JsonProperty("price")
    private int price;
    @JsonProperty("rating")
    private double rating;
    @JsonProperty("sd")
    private String sd;
    @JsonProperty("ssd")
    private String ssd;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CPU")
    public String getCpu() {
        return cpu;
    }

    @JsonProperty("CPU")
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @JsonProperty("camera")
    public String getCamera() {
        return camera;
    }

    @JsonProperty("camera")
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @JsonProperty("capacity")
    public List<String> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(List<String> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("color")
    public List<String> getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(List<String> color) {
        this.color = color;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("images")
    public List<String> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<String> images) {
        this.images = images;
    }

    @JsonProperty("isFavorites")
    public boolean isIsFavorites() {
        return isFavorites;
    }

    @JsonProperty("isFavorites")
    public void setIsFavorites(boolean isFavorites) {
        this.isFavorites = isFavorites;
    }

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonProperty("rating")
    public double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(double rating) {
        this.rating = rating;
    }

    @JsonProperty("sd")
    public String getSd() {
        return sd;
    }

    @JsonProperty("sd")
    public void setSd(String sd) {
        this.sd = sd;
    }

    @JsonProperty("ssd")
    public String getSsd() {
        return ssd;
    }

    @JsonProperty("ssd")
    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
