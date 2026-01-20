package lt.esdc.designpatterns.model.decorator;

import lt.esdc.designpatterns.model.Dessert;

public abstract class DessertDecorator implements Dessert {

    protected final Dessert dessert;

    protected DessertDecorator(Dessert dessert) {
        this.dessert = dessert;
    }
}