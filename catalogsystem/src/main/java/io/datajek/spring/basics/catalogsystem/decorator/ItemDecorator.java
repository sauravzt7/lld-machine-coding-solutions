package io.datajek.spring.basics.catalogsystem.decorator;

import io.datajek.spring.basics.catalogsystem.model.Item;

public abstract class ItemDecorator implements Item{

    private  Item item;

    public ItemDecorator(Item item) {
        if(item == null ){
            throw new IllegalArgumentException("Item can not be null");
        }
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public double getPrice() {
        return item.getPrice();
    }
}
