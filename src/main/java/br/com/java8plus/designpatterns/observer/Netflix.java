package br.com.java8plus.designpatterns.observer;

import lombok.Getter;

import java.util.Observable;

@Getter
public class Netflix extends Observable {

    private String newMovie;

    public void setNewMovie(String newMovie) {
        this.newMovie = newMovie;

        setChanged();
        notifyObservers();
    }
}
