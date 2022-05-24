package br.com.java8plus.designpatterns.observer;

public class MainNetflix {

    public static void main(String[] args) throws InterruptedException {
        Netflix netflix = new Netflix();
        Subscriber subscriber1 = new Subscriber(netflix);
        Subscriber subscriber2 = new Subscriber(netflix);

        netflix.setNewMovie("Star Wars");
        netflix.setNewMovie("Velozes e Furiosos 50");
        netflix.setNewMovie("Planeta dos macacos");
    }
}
