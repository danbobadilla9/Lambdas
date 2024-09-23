package com.debuggeando_ideas.realApps;

import java.util.concurrent.*;

public class ConcurrenceLambdas {

    // Runable no regresa nada
    static Runnable printerSum = () -> {
        long r = 0;
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 100000; i++){
            r += i;
        }
        System.out.println("Total "+ r);
    };
    // calleable si regresa un valor , usado en api rest
    static Callable<Long> getSUM = () -> {
        long r = 0;
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 100000; i++){
            r += i;
        }
        return r;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(printerSum);
        Future<Long> result = exec.submit(getSUM);
        System.out.println("resultado :"+result.get());
        exec.shutdown();
    }

}
