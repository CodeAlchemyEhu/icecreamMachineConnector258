package lt.esdc.designpatterns.machine.state;

public interface MachineConnector {
    void executeRealMachine(String command) throws Exception;
}