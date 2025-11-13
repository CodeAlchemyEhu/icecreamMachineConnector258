package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.*;

public interface DessertFactory {
    IceCream createIceCream();
    Milkshake createMilkshake();
    Smoothie createSmoothie();
}
