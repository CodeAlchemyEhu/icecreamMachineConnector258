package lt.esdc.designpatterns.model;

public class BaseDessert implements DessertInterface {

    private final int frozen;
    private final int milk;
    private final int juice;
    private final int water;

    public BaseDessert(int frozen, int milk, int juice, int water) {
        this.frozen = frozen;
        this.milk = milk;
        this.juice = juice;
        this.water = water;
    }

    @Override
    public String getCommand() {
        return frozen + "g "
                + milk + "ml "
                + juice + "ml "
                + water + "ml";
    }
}