package com.debuggeando_ideas.fundamentals;

public class App {

    public static void main(String[] args) {
        DatabaseService mongo = new MongoDB();
        DatabaseService postgres = new PostgresDB();
        System.out.println(mongo.getById(10L));
        System.out.println(postgres.getById(10L));
    }

}
