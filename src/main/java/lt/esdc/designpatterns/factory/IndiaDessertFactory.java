package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.*;

public class IndiaDessertFactory implements DessertFactory {
    @Override
    public IceCream createIceCream() {
        return new IceCream(200, 25, 0, 20);
    }

    @Override
    public Milkshake createMilkshake() {
        return new Milkshake(120, 210, 0, 20);
    }

    @Override
    public Smoothie createSmoothie() {
        return new Smoothie(30, 40, 220, 55);
    }
}
