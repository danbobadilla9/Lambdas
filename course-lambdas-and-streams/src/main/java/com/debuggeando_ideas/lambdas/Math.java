package com.debuggeando_ideas.lambdas;

@FunctionalInterface
public interface Math {
// por ley todas las interfaces funcionales necesitan un metodo abstracto


    abstract Double execute(Double a, Double b);

    default Double suma(Double a, Double b){
        return a + b;
    }



}
