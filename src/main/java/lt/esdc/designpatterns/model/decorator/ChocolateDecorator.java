package lt.esdc.designpatterns.model.decorator;

import lt.esdc.designpatterns.model.Dessert;

public class ChocolateDecorator extends DessertDecorator {

    public ChocolateDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return dessert.getCommand() + " chocolate";
    }
}