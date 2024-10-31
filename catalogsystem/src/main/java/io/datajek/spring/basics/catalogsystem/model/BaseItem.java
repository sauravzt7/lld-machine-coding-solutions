package io.datajek.spring.basics.catalogsystem.model;

public class BaseItem implements Item{
    private String name;
    private double basePrice;


    public BaseItem(String name, double basePrice){
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getDescription() {
        return name != null ? name : "No item found";
    };

    @Override
    public double getPrice() {
        return basePrice;
    }


}
