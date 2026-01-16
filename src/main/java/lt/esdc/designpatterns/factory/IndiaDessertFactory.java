package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.*;
import lt.esdc.designpatterns.model.decorator.ChocolateDecorator;
import lt.esdc.designpatterns.model.decorator.MarshmallowDecorator;
import lt.esdc.designpatterns.model.decorator.SyrupDecorator;

public class IndiaDessertFactory implements DessertFactory {

    @Override
    public Dessert create(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException("Order is empty");
        }

        Dessert dessert;

        switch (tokens[0]) {
            case "icecream":
                dessert = new BaseDessert(200, 25, 0, 20);
                break;
            case "milkshake":
                dessert = new BaseDessert(120, 210, 0, 20);
                break;
            case "smoothie":
                dessert = new BaseDessert(30, 40, 220, 55);
                break;
            default:
                throw new IllegalArgumentException("Unknown dessert: " + tokens[0]);
        }

        // toppings → decorators
        for (int i = 1; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "chocolate":
                    dessert = new ChocolateDecorator(dessert);
                    break;
                case "marshmallow":
                    dessert = new MarshmallowDecorator(dessert);
                    break;
                case "syrup":
                    dessert = new SyrupDecorator(dessert);
                    break;
                default:
                    break;
            }
        }

        return dessert;
    }
}