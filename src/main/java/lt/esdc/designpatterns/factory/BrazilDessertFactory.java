package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.*;

public class BrazilDessertFactory implements DessertFactory {
    @Override
    public IceCream createIceCream() {
        return new IceCream(220, 20, 0, 15);
    }

    @Override
    public Milkshake createMilkshake() {
        return new Milkshake(130, 230, 0, 25);
    }

    @Override
    public Smoothie createSmoothie() {
        return new Smoothie(35, 40, 240, 60);
    }
}
