package lt.esdc.designpatterns.machine.state;

import lt.esdc.designpatterns.machine.IcecreamMachineV16;
import lt.esdc.designpatterns.machine.IcecreamMachineV77;

public class MachineState {

    // внутренний enum для состояний машины
    private enum StateType { OPEN, CLOSED, SEMI_CLOSED }

    private StateType currentState = StateType.OPEN;
    private int errorCount = 0;
    private int ignoredCount = 0;

    // Для V16
    public void handle(IcecreamMachineV16 machine, String order) {
        switch (currentState) {
            case OPEN -> {
                try {
                    machine.send(order);
                    errorCount = 0;
                } catch (Exception e) {
                    if (++errorCount >= 2) switchToClosed();
                }
            }
            case CLOSED -> handleClosed();
            case SEMI_CLOSED -> {
                try {
                    machine.send(order);
                    switchToOpen();
                } catch (Exception e) {
                    switchToClosed();
                }
            }
        }
    }

    // Для V77
    public void handle(IcecreamMachineV77 machine, String order) {
        switch (currentState) {
            case OPEN -> {
                try {
                    String token = machine.getToken();
                    String session = machine.openSession(token);
                    machine.makeDessert(token, session, order);
                    machine.closeSession(token, session);
                    errorCount = 0;
                } catch (Exception e) {
                    if (++errorCount >= 2) switchToClosed();
                }
            }
            case CLOSED -> handleClosed();
            case SEMI_CLOSED -> {
                try {
                    String token = machine.getToken();
                    String session = machine.openSession(token);
                    machine.makeDessert(token, session, order);
                    machine.closeSession(token, session);
                    switchToOpen();
                } catch (Exception e) {
                    switchToClosed();
                }
            }
        }
    }

    // Обработка закрытого состояния
    private void handleClosed() {
        if (++ignoredCount >= 5) {
            ignoredCount = 0;
            currentState = StateType.SEMI_CLOSED;
        }
    }

    private void switchToClosed() {
        currentState = StateType.CLOSED;
        errorCount = 0;
        ignoredCount = 0;
    }

    private void switchToOpen() {
        currentState = StateType.OPEN;
        errorCount = 0;
        ignoredCount = 0;
    }

    // безопасный доступ к текущему состоянию как строке
    public String getCurrentState() {
        return currentState.name();
    }
}