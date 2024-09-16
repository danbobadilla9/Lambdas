package com.debuggeando_ideas.fundamentals;

import java.util.stream.IntStream;

public class LambdasScope {

    public static void main(String[] args) {
        int num = 10;
        // la variable esta fuera de la expresión del lambda, esto porque normalmente las expresiones lambda corre por otro hilo 
        IntStream.range(1, 10).forEach(i -> num = num + i);

    }

}
