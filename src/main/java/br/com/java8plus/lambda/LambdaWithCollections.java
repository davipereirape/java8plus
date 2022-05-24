package br.com.java8plus.lambda;

import br.com.java8plus.lambda.domain.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaWithCollections {

    public static void main(String[] args) {
        // Collection without lambda
        System.out.println("Print all elements of list!");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Integer n : list) {
            System.out.println(n);
        }

        // Collection with lambda
        System.out.println("Print all elements of list (with lambda)!");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));
        // or list2.forEach(System.out::println);

        // Lambda with conditions
        System.out.println("Print all elements pair (with lambda)!");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list3.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        // Lambda with math expression
        System.out.println("Print all square of elements of list (with lambda)!");
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list4.forEach(n -> System.out.println(n * n));

        // OrderListWithoutLambda
        orderListWithoutLambda();

        // orderListWithLambda
        orderListWithLambda();

        // Using filter with stream of data and lambda
        List<Person> peopleList = getPeople();
        List<Person> thirties = peopleList.stream()
                .filter(p -> p.getAge() > 30).collect(Collectors.toList());
        System.out.println("Just in thirties years old!");
        thirties.forEach(p -> System.out.println(p.getName()));

        System.out.println("People start name with E:");
        List<Person> nomesIniciadosE = peopleList.stream().filter(p
                -> p.getName().startsWith("E")).collect(Collectors.toList());
        nomesIniciadosE.forEach(p -> System.out.println(p.getName()));

        // Dinamic Method (Predicate) with lambda
        printNumberWithDinamicMethodAndLambda();
    }

    private static void orderListWithoutLambda() {
        System.out.println("Ordering person by name:");
        List<Person> peopleList = getPeople();

        Collections.sort(peopleList, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2){
                return person1.getName().compareTo(person2.getName());
            }
        });
        peopleList.forEach(p -> System.out.println(p.getName()));

        System.out.println("Ordering person by age:");
        Collections.sort(peopleList, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2){
                return person1.getAge().compareTo(person2.getAge());
            }
        });
        peopleList.forEach(p -> System.out.println(p.getName()));
    }

    private static void orderListWithLambda() {
        System.out.println("Ordering person by name:");
        List<Person> peopleList = getPeople();

        Collections.sort(peopleList, (Person pessoa1, Person pessoa2)
                -> pessoa1.getName().compareTo(pessoa2.getName()));
        peopleList.forEach(p -> System.out.println(p.getName()));

        System.out.println("Ordering person by age:");
        Collections.sort(peopleList, (Person pessoa1, Person pessoa2)
                -> pessoa1.getAge().compareTo(pessoa2.getAge()));
        peopleList.forEach(p -> System.out.println(p.getName()));
    }

    private static void printNumberWithDinamicMethodAndLambda() {
        System.out.println("Creating list with numbers to operations");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        System.out.println("Print all numbers:");
        dinamicMethodVerifyExpression(list, (n)->true);

        System.out.println("No print numbers:");
        dinamicMethodVerifyExpression(list, (n)->false);

        System.out.println("Print just pair numbers:");
        dinamicMethodVerifyExpression(list, (n)-> n%2 == 0 );

        System.out.println("Print just odd numbers:");
        dinamicMethodVerifyExpression(list, (n)-> n%2 == 1 );

        System.out.println("Print numbers bigger 5:");
        dinamicMethodVerifyExpression(list, (n)-> n > 5 );

        System.out.println("Print numbers bigger 5 and lesser 10:");
        dinamicMethodVerifyExpression(list, (n)-> n > 5 && n < 10);

    }

    public static void dinamicMethodVerifyExpression(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(n -> {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        });
    }


    private static List<Person> getPeople() {
        return Arrays.asList(Person.builder().name("Eduardo").age(29).build(),
                Person.builder().name("Luiz").age(32).build(),
                Person.builder().name("Bruna").age(26).build());
    }

}
