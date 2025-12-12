package lt.esdc.designpatterns.controller.impl;

import lt.esdc.designpatterns.controller.IcecreamMachineController;
import lt.esdc.designpatterns.factory.DessertFactory;
import lt.esdc.designpatterns.machine.IcecreamMachineV16;
import lt.esdc.designpatterns.model.Dessert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class IcecreamMachineControllerImpl implements IcecreamMachineController {

    private static final Logger logger = LoggerFactory.getLogger(IcecreamMachineControllerImpl.class);


    private static volatile IcecreamMachineControllerImpl INSTANCE;

    private final DessertFactory factory;
    private final IcecreamMachineV16 machine;

    private IcecreamMachineControllerImpl(DessertFactory factory, IcecreamMachineV16 machine) {
        if (factory == null) {
            throw new IllegalArgumentException("DessertFactory cannot be null");
        }
        if (machine == null) {
            throw new IllegalArgumentException("IcecreamMachineV16 cannot be null");
        }
        this.factory = factory;
        this.machine = machine;
    }


    public static IcecreamMachineControllerImpl getInstance(DessertFactory factory, IcecreamMachineV16 machine) {
        if (INSTANCE == null) {
            synchronized (IcecreamMachineControllerImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IcecreamMachineControllerImpl(factory, machine);
                } else {
                    logger.warn("IcecreamMachineControllerImpl already initialized; ignoring provided factory/machine.");
                }
            }
        }
        return INSTANCE;
    }


    public static IcecreamMachineControllerImpl getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("IcecreamMachineControllerImpl is not initialized. Call getInstance(factory, machine) first.");
        }
        return INSTANCE;
    }

    @Override
    public void processOrder(String[] orders) {
        if (orders == null || orders.length == 0) {
            logger.warn("Empty order array received; nothing to process.");
            return;
        }

        for (String order : orders) {
            if (order == null || order.isBlank()) {
                logger.warn("Skipping empty order element.");
                continue;
            }

            String key = order.trim().toLowerCase();

            Dessert dessert = switch (key) {
                case "icecream", "ice-cream", "ice_cream" -> factory.createIceCream();
                case "milkshake", "milk-shake", "milk_shake" -> factory.createMilkshake();
                case "smoothie" -> factory.createSmoothie();
                default -> {
                    logger.warn("Unknown dessert type: {}", order);
                    yield null;
                }
            };

            if (dessert != null) {
                String command = dessert.getCommand();
                logger.info("Sending to machine ({}): {}", dessert.getType(), command);
                machine.send(command);
            }
        }
    }
}
