package lt.esdc.designpatterns.machine.state;

import lt.esdc.designpatterns.machine.IcecreamMachineV16;

public class StatefulV16Connector {

    private final IcecreamMachineV16 machine;
    private final MachineState state = new MachineState();

    public StatefulV16Connector(IcecreamMachineV16 machine) {
        this.machine = machine;
    }

    public void send(String command) {
        state.handle(machine, command);
    }

    public MachineState getState() {
        return state;
    }
}