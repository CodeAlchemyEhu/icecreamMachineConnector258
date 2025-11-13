package lt.esdc.designpatterns;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.controller.impl.IcecreamMachineControllerImpl;
import lt.esdc.designpatterns.factory.*;
import lt.esdc.designpatterns.machine.*;

public class Main {
    public static void main(String[] args) {
        IcecreamMachineV16 machine = new IcecreamMachineConnector();

        DessertFactory factory = new BrazilDessertFactory();
        IcecreamMachineController controller = new IcecreamMachineControllerImpl(factory, machine);

        String[] orders = {"icecream", "milkshake", "smoothie"};
        controller.processOrder(orders);
    }
}