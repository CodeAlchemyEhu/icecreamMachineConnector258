package lt.esdc.designpatterns.model.decorator;


import lt.esdc.designpatterns.model.DessertInterface;

public abstract class DessertDecorator implements DessertInterface {

    protected final DessertInterface dessert;

    public DessertDecorator(DessertInterface dessert) {
        if (dessert == null) throw new IllegalArgumentException("Dessert cannot be null");
        this.dessert = dessert;
    }

    @Override
    public String getCommand() {
        return dessert.getCommand();
    }

    @Override
    public String getType() {
        return dessert.getType();
    }
}