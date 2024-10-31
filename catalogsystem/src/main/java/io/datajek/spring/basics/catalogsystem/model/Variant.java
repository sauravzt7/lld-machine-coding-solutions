package io.datajek.spring.basics.catalogsystem.model;

public class Variant {
    private String name;
    private double price;

    public Variant(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}

