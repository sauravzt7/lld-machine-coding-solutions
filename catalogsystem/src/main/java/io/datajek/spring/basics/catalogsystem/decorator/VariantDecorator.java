package io.datajek.spring.basics.catalogsystem.decorator;

import io.datajek.spring.basics.catalogsystem.model.BaseItem;
import io.datajek.spring.basics.catalogsystem.model.Variant;
import io.datajek.spring.basics.catalogsystem.model.Item;

public class VariantDecorator extends  ItemDecorator{

    private Variant variant;

    public VariantDecorator(Item item, Variant variant){
        super(item);
        this.variant = variant;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Variants :" + variant.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + variant.getPrice();
    }


}
