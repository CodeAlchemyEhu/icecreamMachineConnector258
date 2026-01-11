package lt.esdc.designpatterns;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.controller.impl.IcecreamMachineControllerImpl;
import lt.esdc.designpatterns.factory.BrazilDessertFactory;
import lt.esdc.designpatterns.factory.DessertFactory;
import lt.esdc.designpatterns.machine.IcecreamMachineConnector;
import lt.esdc.designpatterns.machine.IcecreamMachineV16;

public class Main {
    public static void main(String[] args) {

        IcecreamMachineV16 machine = new IcecreamMachineConnector();

        DessertFactory factory = new BrazilDessertFactory();

        IcecreamMachineController controller = IcecreamMachineControllerImpl.getInstance(factory, machine);

        String[] orders = {"icecream marshmallow chocolate", "milkshake syrup", "smoothie"};
        controller.processOrder(orders);
    }
}
