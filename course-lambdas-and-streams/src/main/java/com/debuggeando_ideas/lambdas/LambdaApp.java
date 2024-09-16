package com.debuggeando_ideas.lambdas;

public class LambdaApp {

    public static void main(String [] args){

        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b) {
                return a - b;
            }
        };

        System.out.println(substract.execute(10.2D,5.58D));

        Math multiply = (a,b) -> {
            return a * b;
        };

        System.out.println(multiply.execute(10.2,9.8));

        Math divide = (a,b) ->  a / b;

        System.out.println(divide.execute(10000.5,15.2));

        System.out.println(divide.suma(10.8,5.3));

    }

}
