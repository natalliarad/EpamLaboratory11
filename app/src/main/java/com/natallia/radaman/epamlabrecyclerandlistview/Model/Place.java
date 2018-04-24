package com.natallia.radaman.epamlabrecyclerandlistview.Model;

/**
 *
 */
public class Place {
    private String title;
    private String coordinates;
    private String imageSrc;
    //TODO coordinates
    private String placeType;
    private String workTime;
    private int rating;
    private String description;

    public Place(String title) {
        this.title = title;
    }

    public Place(String title, String coordinates, String imageSrc) {
        this.title = title;
        this.coordinates = coordinates;
        this.imageSrc = imageSrc;
    }

    public Place(String title, String coordinates, String imageSrc, int rating) {
        this.title = title;
        this.coordinates = coordinates;
        this.imageSrc = imageSrc;
        this.rating = rating;
    }

    public Place(String title, String coordinates, String imageSrc, int rating, String description) {
        this.title = title;
        this.coordinates = coordinates;
        this.imageSrc = imageSrc;
        this.rating = rating;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
