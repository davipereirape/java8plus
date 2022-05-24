package br.com.java8plus.designpatterns.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
public class Subscriber implements Observer  {

    private Observable netflixUser;
    private String newMovie;

    public Subscriber(Observable netflixUser) {
        this.netflixUser = netflixUser;
        netflixUser.addObserver(this);
    }

    @Override
    public void update(Observable netflixInfSubject, Object arg1) {
        if (netflixInfSubject instanceof Netflix) {
            Netflix netflix = (Netflix) netflixInfSubject;
            this.newMovie = netflix.getNewMovie();

            System.out.println("Look out, We have a new movie in ours channel of Netflix. The name of movie is: "
                    + getNewMovie());
        }
    }

    public boolean equals(Subscriber other){
        return ((other == null) || (getClass() != other.getClass())) ? Boolean.FALSE : other == this;
    }
}