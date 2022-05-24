package br.com.java8plus.lambda.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String name;
    private Integer age;
}
