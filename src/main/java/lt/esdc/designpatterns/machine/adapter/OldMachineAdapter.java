package lt.esdc.designpatterns.machine.adapter;

import lt.esdc.designpatterns.machine.IcecreamMachineAdapter;
import lt.esdc.designpatterns.machine.IcecreamMachineV16;

public class OldMachineAdapter implements IcecreamMachineAdapter {

    private final IcecreamMachineV16 machine;

    public OldMachineAdapter(IcecreamMachineV16 machine) {
        this.machine = machine;
    }

    @Override
    public void send(String command) {
        String[] parts = command.split(" ");

        String cleanCommand =
                parts[0] + " " +
                        parts[1] + " " +
                        parts[2] + " " +
                        parts[3];

        machine.send(cleanCommand);
    }
}