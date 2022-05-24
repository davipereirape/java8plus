package br.com.java8plus.lambda;

public class LambdaWithThread {

    public static void main (String args []) {
        // Without lambda
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread with internal class!");
            }
        };
        new Thread(r).start();

        // With lambda
        Runnable r2 = () -> System.out.println("Thread with lambda!");
        new Thread(r2).start();

        // With lambda and param in an instance of class
        new Thread(
                () -> System.out.println("Hello World")
        ).start();
    }

}
