package lt.esdc.designpatterns.machine;

import java.util.UUID;

public class NewIcecreamMachineConnector implements IcecreamMachineV77 {

    @Override
    public String getToken() {
        return "TOKEN";
    }

    @Override
    public String openSession(String token) {
        return "SESSION";
    }

    @Override
    public void makeDessert(String token, String session, String command) {
        System.out.println("V77 machine preparing: " + command);
    }

    @Override
    public void closeSession(String token, String session) {
        System.out.println("Session closed");
    }
}