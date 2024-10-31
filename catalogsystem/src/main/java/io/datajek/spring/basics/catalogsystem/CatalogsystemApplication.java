package io.datajek.spring.basics.catalogsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.datajek.spring.basics.catalogsystem.model.*;
import io.datajek.spring.basics.catalogsystem.decorator.*;

@SpringBootApplication
public class CatalogsystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CatalogsystemApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Create base item
        BaseItem pizza = new BaseItem("Pizza", 8.0);
        System.out.println("Base Item: " + pizza.getDescription() + ", Price: $" + pizza.getPrice());

        // Create variant
        Variant medium = new Variant("Medium", 2.0);

        // Create add-ons
        AddOn whiteCheese = new AddOn("White Cheese", 3.0);
        AddOn yellowCheese = new AddOn("Yellow Cheese", 1.5);

        // Decorate with variant
        Item variantPizza = new VariantDecorator(pizza, medium);
        System.out.println("After Variant: " + variantPizza.getDescription() + ", Price: $" + variantPizza.getPrice());

        // Decorate with first add-on
        Item pizzaWithWhiteCheese = new AddOnDecorator(variantPizza, whiteCheese);
        System.out.println("After White Cheese: " + pizzaWithWhiteCheese.getDescription() + ", Price: $" + pizzaWithWhiteCheese.getPrice());

        // Decorate with second add-on
        Item customizedPizza = new AddOnDecorator(pizzaWithWhiteCheese, yellowCheese);
        System.out.println("Final Item: " + customizedPizza.getDescription() + ", Price: $" + customizedPizza.getPrice());
    }
}
