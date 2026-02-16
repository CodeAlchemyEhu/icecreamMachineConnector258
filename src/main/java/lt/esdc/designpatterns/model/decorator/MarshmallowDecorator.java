package lt.esdc.designpatterns.model.decorator;


import lt.esdc.designpatterns.model.DessertInterface;

public class MarshmallowDecorator extends DessertDecorator {

    public MarshmallowDecorator(DessertInterface dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return super.getCommand() + " marshmallow";
    }
}