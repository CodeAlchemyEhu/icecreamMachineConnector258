package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.Dessert;

public class BrazilDessertFactory implements DessertFactory {

    @Override
    public Dessert createIceCream() {
        return new Dessert.Builder()
                .type("icecream")
                .frozenMass(220)
                .milk(20)
                .juice(0)
                .water(15)
                .build();
    }

    @Override
    public Dessert createMilkshake() {
        return new Dessert.Builder()
                .type("milkshake")
                .frozenMass(130)
                .milk(230)
                .juice(0)
                .water(25)
                .build();
    }

    @Override
    public Dessert createSmoothie() {
        return new Dessert.Builder()
                .type("smoothie")
                .frozenMass(35)
                .milk(40)
                .juice(240)
                .water(60)
                .build();
    }
}
