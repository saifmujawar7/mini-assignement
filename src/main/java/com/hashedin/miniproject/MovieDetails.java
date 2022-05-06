package com.hashedin.miniproject;

import javax.persistence.*;


@Entity
@Table(name = "movie_details")
public class MovieDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imdb_title_id")
    private String imdb_title_id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;
    @Column(name = "genre")
    private String genre;
    @Column(name = "duration")
    private int duration;
    @Column(name = "country")
    private String country;
    @Column(name = "director")
    private String director;
    @Column(name = "budget")
    private String budget;
    @Column(name = "reviews_from_users")
    private String reviews_from_users;

    public MovieDetails() {
        super();
    }

    public String getImdb_title_id() {
        return imdb_title_id;
    }

    public void setImdb_title_id(String imdb_title_id) {
        this.imdb_title_id = imdb_title_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getReviews_from_users() {
        return reviews_from_users;
    }

    public String setReviews_from_users(String reviews_from_users) {
        this.reviews_from_users = reviews_from_users;
        return reviews_from_users;
    }
}
