package lt.esdc.designpatterns.controller.impl;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.factory.DessertFactory;
import lt.esdc.designpatterns.machine.IcecreamMachineV16;
import lt.esdc.designpatterns.model.Dessert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IcecreamMachineControllerImpl implements IcecreamMachineController {

    private static final Logger logger = LoggerFactory.getLogger(IcecreamMachineControllerImpl.class);

    private final DessertFactory factory;
    private final IcecreamMachineV16 machine;

    public IcecreamMachineControllerImpl(DessertFactory factory, IcecreamMachineV16 machine) {
        this.factory = factory;
        this.machine = machine;
    }

    @Override
    public void processOrder(String[] orders) {
        for (String order : orders) {
            Dessert dessert = switch (order.toLowerCase()) {
                case "icecream" -> factory.createIceCream();
                case "milkshake" -> factory.createMilkshake();
                case "smoothie" -> factory.createSmoothie();
                default -> {
                    logger.warn("⚠️ Неизвестный тип десерта: {}", order);
                    yield null;
                }
            };

            if (dessert != null) {
                String command = dessert.getCommand();
                logger.info("➡️ Отправляем в машину: {}", command);
                machine.send(command);
            }
        }
    }
}
