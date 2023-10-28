package io.javabrains.moviecatalogservice.model;

public class Rating {

    private String id;
    private double rating;

    public Rating() {
    }

    public Rating(String id, double rating) {
        this.id = id;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
