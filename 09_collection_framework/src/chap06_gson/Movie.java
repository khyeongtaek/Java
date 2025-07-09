package chap06_gson;

import java.util.*;

public class Movie {

    private String title;
    private String director;
    private List<String> actors;
    private double stars;

    public Movie() {

    }

    public Movie(String title, String director, List<String> actors, double stars) {
        super();
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", director=" + director + ", actors=" + actors + ", stars=" + stars + "]";
    }

}
