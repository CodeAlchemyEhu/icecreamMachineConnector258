package lt.esdc.designpatterns.machine.state;

import lt.esdc.designpatterns.machine.IcecreamMachineV77;

public class StatefulV77Connector {

    private final IcecreamMachineV77 machine;
    private final MachineState state = new MachineState();

    public StatefulV77Connector(IcecreamMachineV77 machine) {
        this.machine = machine;
    }

    public void send(String command) {
        state.handle(machine, command);
    }

    public MachineState getState() {
        return state;
    }
}