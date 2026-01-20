package lt.esdc.designpatterns.model.decorator;

import lt.esdc.designpatterns.model.Dessert;

public class SyrupDecorator extends DessertDecorator {

    public SyrupDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return dessert.getCommand() + " syrup";
    }
}