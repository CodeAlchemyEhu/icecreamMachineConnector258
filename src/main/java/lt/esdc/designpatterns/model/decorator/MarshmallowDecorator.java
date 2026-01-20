package lt.esdc.designpatterns.model.decorator;

import lt.esdc.designpatterns.model.Dessert;

public class MarshmallowDecorator extends DessertDecorator {

    public MarshmallowDecorator(Dessert dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return dessert.getCommand() + " marshmallow";
    }
}