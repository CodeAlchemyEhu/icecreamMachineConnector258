package lt.esdc.designpatterns;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.controller.impl.IcecreamMachineControllerImpl;
import lt.esdc.designpatterns.factory.BrazilDessertFactory;
import lt.esdc.designpatterns.factory.IndiaDessertFactory;
import lt.esdc.designpatterns.machine.IcecreamMachineConnector;
import lt.esdc.designpatterns.machine.NewIcecreamMachineConnector;
import lt.esdc.designpatterns.machine.adapter.NewMachineAdapter;
import lt.esdc.designpatterns.machine.adapter.OldMachineAdapter;

public class Main {

    public static void main(String[] args) {

        String[] order = {
                "icecream chocolate syrup",
                "milkshake",
                "smoothie marshmallow"
        };

        IcecreamMachineController oldMachineController =
                new IcecreamMachineControllerImpl(
                        new BrazilDessertFactory(),
                        new OldMachineAdapter(new IcecreamMachineConnector())
                );

        oldMachineController.processOrder(order);

        IcecreamMachineController newMachineController =
                new IcecreamMachineControllerImpl(
                        new IndiaDessertFactory(),
                        new NewMachineAdapter(new NewIcecreamMachineConnector())
                );

        newMachineController.processOrder(order);
    }
}