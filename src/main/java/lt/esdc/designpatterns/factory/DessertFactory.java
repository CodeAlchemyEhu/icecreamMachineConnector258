package lt.esdc.designpatterns.factory;

import lt.esdc.designpatterns.model.Dessert;

public interface DessertFactory {
    Dessert create(String[] tokens);
}