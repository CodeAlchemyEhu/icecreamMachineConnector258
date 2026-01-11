package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.Dessert;

public interface DessertFactory {
    Dessert createIceCream();
    Dessert createMilkshake();
    Dessert createSmoothie();
}
