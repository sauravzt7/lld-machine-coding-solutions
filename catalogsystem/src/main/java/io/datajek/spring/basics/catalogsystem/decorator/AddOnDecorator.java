package io.datajek.spring.basics.catalogsystem.decorator;

import io.datajek.spring.basics.catalogsystem.model.AddOn;
import io.datajek.spring.basics.catalogsystem.model.Item;

public class AddOnDecorator extends ItemDecorator{

    private AddOn addOn;

    public AddOnDecorator(Item item, AddOn addOn){
        super(item);
        this.addOn = addOn;
    }

    @Override
    public String getDescription() {
//        if(item == null){
//            return "No item found";
//        }
        return super.getDescription() + "AddOns :" + addOn.getName();
    }

    @Override
    public double getPrice() {
//        if(item == null){
//            return 0.0000;
//        }
        return super.getPrice() + addOn.getPrice();
    }


}
