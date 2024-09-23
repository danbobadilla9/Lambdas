//package com.debuggeando_ideas.realApps;
//
//
//import java.util.List;
//
//public class StrategyLambdas {
//
//
//
//    public static void main(String[] args) {
//        ProductL product1 = ProductL.builder().id(1L).name("Bear").price(150.0).userType("BASIC").build();
//        ProductL product2 = ProductL.builder().id(2L).name("Bear").price(150.0).userType("PLUS").build();
//        ProductL product3 = ProductL.builder().id(3L).name("Bear").price(150.0).userType("PRIME").build();
//
//        List<ProductL> products = List.of(product1, product2, product3);
//        products.forEach( p -> {
//            switch (p.getUserType()){
//                case "BASIC": p.setDiscountStrategy(Strategies.basicDiscount); break;
//                case "PLUS": p.setDiscountStrategy(Strategies.plussDiscount); break;
//                case "PRIME": p.setDiscountStrategy(Strategies.primeDiscount); break;
//            }
//
//        });
//
//        products.forEach(p -> {
//            System.out.println("Price "+p.getPrice()+" User Type "+p.getUserType()+" Discount "+p.getDiscountStrategy().get(p.getPrice()));
//        });
//    }
//}
//
//
//@FunctionalInterface
//interface ApplyDiscountStrategy {
//    Double get(Double price);
//
//}
//
