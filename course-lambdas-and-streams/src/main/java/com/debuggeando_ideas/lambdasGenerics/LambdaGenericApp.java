package com.debuggeando_ideas.lambdasGenerics;

import com.debuggeando_ideas.fundamentals.Employee;

import java.util.List;

public class LambdaGenericApp {

    public static void main(String[] args) {


        Printer<Employee> printer = (employe) -> {
            System.out.println(employe.toString());
        };
        Employee employee = new Employee("israel", 500.2, "dibs");
        printer.print(employee);

        Printer<String> printString = value -> System.out.println(value);


        printString.print("Buenos dias ");

        List<String> countries = List.of("Mexico", "Colombia", "Argentina", "Chile");

        for(String c : countries){
            System.out.println(c);
        }

        // cualquier coleccion que utilice la interface Collection tiene le metodo foreach
        // donde consumer es una interfaz  funcional
        countries.forEach(c -> System.out.println(c.toUpperCase()));



    }

}
