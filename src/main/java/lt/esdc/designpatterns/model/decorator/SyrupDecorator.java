package lt.esdc.designpatterns.model.decorator;


import lt.esdc.designpatterns.model.DessertInterface;

public class SyrupDecorator extends DessertDecorator {

    public SyrupDecorator(DessertInterface dessert) {
        super(dessert);
    }

    @Override
    public String getCommand() {
        return super.getCommand() + " syrup";
    }
}