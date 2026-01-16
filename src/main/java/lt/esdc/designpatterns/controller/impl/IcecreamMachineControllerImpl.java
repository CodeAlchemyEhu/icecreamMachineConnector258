package lt.esdc.designpatterns.controller.impl;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.factory.DessertFactory;
import lt.esdc.designpatterns.machine.IcecreamMachineAdapter;
import lt.esdc.designpatterns.model.Dessert;

public class IcecreamMachineControllerImpl implements IcecreamMachineController {

    private final DessertFactory factory;
    private final IcecreamMachineAdapter adapter;

    public IcecreamMachineControllerImpl(
            DessertFactory factory,
            IcecreamMachineAdapter adapter
    ) {
        this.factory = factory;
        this.adapter = adapter;
    }

    @Override
    public void processOrder(String[] orders) {
        for (String order : orders) {
            String[] tokens = order.toLowerCase().split("\\s+");
            Dessert dessert = factory.create(tokens);
            adapter.send(dessert.getCommand());
        }
    }
}