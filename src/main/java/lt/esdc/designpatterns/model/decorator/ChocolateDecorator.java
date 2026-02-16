package lt.esdc.designpatterns.model.decorator;


import lt.esdc.designpatterns.model.DessertInterface;

public class ChocolateDecorator extends DessertDecorator {

    public ChocolateDecorator(DessertInterface dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return super.getCommand() + " chocolate";
    }
}