package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.Dessert;

public class IndiaDessertFactory implements DessertFactory {

    @Override
    public Dessert createIceCream() {
        return new Dessert.Builder()
                .type("icecream")
                .frozenMass(200)
                .milk(25)
                .juice(0)
                .water(20)
                .build();
    }

    @Override
    public Dessert createMilkshake() {
        return new Dessert.Builder()
                .type("milkshake")
                .frozenMass(120)
                .milk(210)
                .juice(0)
                .water(20)
                .build();
    }

    @Override
    public Dessert createSmoothie() {
        return new Dessert.Builder()
                .type("smoothie")
                .frozenMass(30)
                .milk(40)
                .juice(220)
                .water(55)
                .build();
    }
}
