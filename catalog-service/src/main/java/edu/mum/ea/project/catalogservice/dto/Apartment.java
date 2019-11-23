package edu.mum.ea.project.catalogservice.dto;


public class Apartment {
    Long id;
    String title;
    String details;
    String location;
    String imageUrl;
    Double cost;

    public Apartment() {
    }


    public Apartment(Long id, String title, String details, String location, String imageUrl, Double cost) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.location = location;
        this.imageUrl = imageUrl;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", location='" + location + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cost=" + cost +
                '}';
    }
}
