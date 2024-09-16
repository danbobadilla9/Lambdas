package com.debuggeando_ideas.referenciaMetodos;

import lombok.ToString;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class App {

    // funcionalidad de java 8+, sustituye una expresion lmbda cuya única instrucción consiste en la llamada a un método
    // el compilador infiere las variables dadas por parametro en el argumento del método
    // existen 4 tipos
    // 1) Método estatico
    // 2) Método de un objeto específico
    // 3) Método arbitrario
    // 4) Método constructor

    public static void main(String[] args) {
        // referencia por metodo

        List<Integer> numbers = new ArrayList<>(10);

        IntStream repeat = IntStream.range(1, 11);
        // utilizando expresiones lambda
        //repeat.forEach( i -> numbers.add(i));
        repeat.forEach(numbers::add);

        System.out.println(numbers);

        // referencia por metodo estatico
        System.out.println(UUID.randomUUID().toString());
    // Esta es una interface functional, creamos la lambda
        Supplier<UUID> getToken = () -> UUID.randomUUID();
        // creamos una referencia al metodo
        Supplier<UUID> getToken2 = UUID::randomUUID;
        System.out.println(getToken.get());
        System.out.println(getToken2.get());

        // referencia por constructor
        // expresion lambda
        Supplier<MyObject> myObjectSupplier = () -> new MyObject();
        // referencia a metodo
        Supplier<MyObject> myObjectSupplier2 =MyObject::new;
        System.out.println(myObjectSupplier.get());
        System.out.println(myObjectSupplier2.get());

        // metodo arbitrario
        // uso de lambdas
        BiPredicate<String, String> equals = (s1, s2) -> s1.equals(s2);
        // uso de referencia arbitraria
        BiPredicate<String, String> equals2 = String::equals;
        boolean flag = equals.test("a", "a");
        System.out.println(flag);
        flag = equals2.test("b", "c");
        System.out.println(flag);


    }



}

@ToString
class MyObject{
    private String string;
    private Integer num;

    public MyObject() {
        this.string = UUID.randomUUID().toString();
        this.num = new Random().nextInt(100);
    }
}