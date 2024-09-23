//package com.debuggeando_ideas.realApps;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.ToString;
//
//@Data
//@Builder
//@ToString
//public class ProductL{
//    private Long id;
//    private String userType;
//    private String name;
//    private Double price;
//    private ApplyDiscountStrategy discountStrategy;
//}
//
//class Strategies {
//    static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;
//    static ApplyDiscountStrategy plussDiscount = p -> p * 0.08;
//    static ApplyDiscountStrategy primeDiscount = p -> p * 0.12;
//}