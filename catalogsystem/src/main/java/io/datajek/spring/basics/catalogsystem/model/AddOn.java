package io.datajek.spring.basics.catalogsystem.model;

public class AddOn {

    private String name;

    private double price;

    public AddOn(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

}
