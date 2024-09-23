package com.debuggeando_ideas.realApps;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 6, 8, 9, 77, 52, 2, 6, 5, 10, 4, 56, 8, 7);
        numbers.sort((a,b) -> a-b);// ordena de menor a mayor
        System.out.println(numbers.toString());
        List<String> names = Arrays.asList("Israel", "jose", "dan", "alan");
        names.sort((a,b) -> a.compareTo(b));
        names.sort(String::compareTo);
        System.out.println(names.toString());
        names.sort(Comparator.reverseOrder());
        System.out.println(names.toString());
        List<Person> persons = Arrays.asList(new Person("Israel",24),new Person("jose",21),new Person("dan",34));
        persons.sort(Comparator.comparingInt(Person::getAge));
    }

}
// comparable se utilizaba en java 8
// despues de java 8 se utiliza lo siguiente
//class Person implements Comparable{
@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age = 0;

    public Person(String name, Integer age){
        name = name;
        age = age;
    }
}
