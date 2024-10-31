package io.datajek.spring.basics.catalogsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Item> items;

    public Category(String name, List<Item> items){
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItemToCategory(Item item){
        items.add(item);
    }
}
