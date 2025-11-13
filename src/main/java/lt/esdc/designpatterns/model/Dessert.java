package lt.esdc.designpatterns.model;

public abstract class Dessert {
    protected int frozenMass;
    protected int milk;
    protected int juice;
    protected int water;

    public Dessert(int frozenMass, int milk, int juice, int water) {
        this.frozenMass = frozenMass;
        this.milk = milk;
        this.juice = juice;
        this.water = water;
    }

    public String getCommand() {
        return String.format("%dg %dml %dml %dml", frozenMass, milk, juice, water);
    }
}
