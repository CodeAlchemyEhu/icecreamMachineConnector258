package lt.esdc.designpatterns.machine;

public interface IcecreamMachineV77 {
    String getToken();
    String openSession(String token);
    void makeDessert(String token, String session, String dessert);
    void closeSession(String token, String session);
}
