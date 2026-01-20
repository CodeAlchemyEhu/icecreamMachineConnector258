package lt.esdc.designpatterns.machine.adapter;

import lt.esdc.designpatterns.machine.IcecreamMachineAdapter;
import lt.esdc.designpatterns.machine.NewIcecreamMachineConnector;

public class NewMachineAdapter implements IcecreamMachineAdapter {

    private final NewIcecreamMachineConnector machine;

    public NewMachineAdapter(NewIcecreamMachineConnector machine) {
        this.machine = machine;
    }

    @Override
    public void send(String command) {
        String token = machine.getToken();
        String session = machine.openSession(token);

        try {
            machine.makeDessert(token, session, command);
        } finally {
            machine.closeSession(token, session);
        }
    }
}