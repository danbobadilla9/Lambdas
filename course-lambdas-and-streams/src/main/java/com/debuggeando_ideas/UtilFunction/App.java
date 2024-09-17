package com.debuggeando_ideas.UtilFunction;

import lombok.ToString;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class App {

    public static void main(String[] args){
        // dentro del paquete java.util.function se encuentran las interfaces funcionales que propone java, las cuales son una especificación
        // esta presente desde java 8+
        // -> function es de tipo generico 2 valores, son para operaciones con objetos
        // -> BiFunction es de tipo generica 3 valores, acepta dos valores y regresa un resultado
        // -> Predicate evalua solo un tipo , es una funcion que regresa true o false, es un IF
        // -> BiPredicate, es lo mismo que el anterior, evalua dos tipos
        // -> Consumer un solo valor, realiza un operacion de entrada pero no regresa nada
        // -> BiConsumer lo mismo que el anterior
        // -> Suplier, retorna un objeto pero no necesita argumentos,
        // -> UnaryOperator extiende de function


        // FUNCTION

        System.out.println(multiply.apply(5));
        System.out.println(sum.apply(10));
        System.out.println(addThenMultiply.apply(5));
        System.out.println(composeMultiply.apply(10));

        // Example FUNCTION

        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("israel", 24));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));
        Person object = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(object);

        // BiFunction, uso en acumuladores
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);

        List<String> result = listCombiner(list1, list2, (l1,l2) -> l1+l2);
        System.out.println(result.toString());

        // PREDICATE
        // cualquier interfaz que utilice util tiene un remove, antes de java 8 no se podian eliminar elementos cuando se iteraba la lista, ahora tenemos removeIf
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 50, 100, 150, 200));
        numbers.removeIf(isBetween.negate());
        System.out.println(numbers.toString());

        // BIPREDICATE
        String s1 = "Hello";
        String s2 = "Word";
        System.out.println(myEquals.test(s1,s2));

        // CONSUMER
        Set<Integer> nums = Set.of(1, 2, 3, 4, 5);
        List<Integer> squares = new LinkedList<>();
        nums.forEach( n -> {
            squares.add(n * n);
        });

        System.out.println(squares);

        //BICONSUMER
        Map<Boolean, String> map = Map.of(true,"this is the truth",false,"this is false");

        map.forEach((k,v) -> {
            System.out.println("Key: "+k+" value: "+v);
        });

        //SUPPLIER
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());

        //UNARYOPERATOR
        String arg = "lambdas";
        System.out.println(funToUpper.apply(arg));
        System.out.println(unaryToUppper.apply(arg));
        System.out.println(int2.applyAsInt(10));


        //BINARYOPERATOR extiende de la interfaz bifunction, por lo que recibe dos argumentos
        BiFunction<String, String, String> normalizerFunc = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        BinaryOperator<String> normalizer = (c, d) -> c.toUpperCase() + " - " + d.toLowerCase();
        System.out.println(normalizerFunc.apply("israel","segundo"));
        System.out.println(normalizerFunc.apply("israel","segundo"));



    }

    static Function<Integer, Integer> multiply = n -> n * 10;
    static Function<Integer, Integer> sum = n -> n + 10;
    static Function<Integer,Integer> addThenMultiply = multiply.andThen(sum);
    static Function<Integer,Integer> composeMultiply = multiply.compose(sum);
    // recibimos de entrada persona y regresa un byte
    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)){

            outputStream.writeObject(p);
            outputStream.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return inMemoryBytes;
    };


    static Function<ByteArrayInputStream, Person> deserializer = bais -> {
        try(ObjectInputStream inputStream = new ObjectInputStream(bais)) {
            return (Person) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    };

    private static<T,U,R>List<R> listCombiner(
            List<T> list1,
            List<U> list2,
            BiFunction<T,U,R> combiner
    ){
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++){
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
    // PREDICATE

    static Predicate<Integer> isGreaterThan100 = n -> n >= 100;
    static Predicate<Integer> isLessThan10 = n -> n < 10;
    //static Predicate<Integer> isBetween = n -> n > 10 && n <= 100;
    static Predicate<Integer> isBetween = isGreaterThan100.or(isLessThan10);

    // PREDICATE

    //BIPREDICATE
    static BiPredicate<String, String> myEquals = (s1, s2) -> s1.concat(s2).equals("HelloWord");
    //BIPREDICATE

    //SUPPLIER
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> productSupplier = () -> new MyProduct(100, "television");

    //SUPPLIER

    // UNARYOPERATOR
    static Function<String, String> funToUpper = String::toUpperCase;
    static UnaryOperator<String> unaryToUppper = String::toUpperCase;
    static UnaryOperator<Integer> int1 = n -> n * n;
    static IntUnaryOperator int2 = n -> n * n;

    //BINARYOPERATOR


    //BINARYOPERATOR


}

@ToString
class Person implements Serializable {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
@ToString
class MyProduct{
    private Integer price;
    private String name;

    public MyProduct(Integer price, String name) {
        this.price = price;
        this.name = name;
    }
}
