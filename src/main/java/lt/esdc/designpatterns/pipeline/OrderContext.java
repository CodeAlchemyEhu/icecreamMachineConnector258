package lt.esdc.designpatterns.pipeline;

import lt.esdc.designpatterns.model.DessertInterface;
import lt.esdc.designpatterns.pricing.DiscountManager;

public class OrderContext {
    public String rawInput;
    public DessertInterface dessert;
    public DiscountManager discountManager;

    public OrderContext(String rawInput) {
        this.rawInput = rawInput;
    }
}