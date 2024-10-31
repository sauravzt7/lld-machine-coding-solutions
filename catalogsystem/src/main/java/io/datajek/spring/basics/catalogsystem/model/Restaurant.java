package io.datajek.spring.basics.catalogsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<Category> categories;

    public Restaurant(String name, List<Category> categories){
        this.name = name;
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category newCategory){
        categories.add(newCategory);
    }
}
