package lt.esdc.designpatterns.model;

public class Dessert {
    private final int frozenMass;
    private final int milk;
    private final int juice;
    private final int water;
    private final String type;

    private Dessert(Builder builder) {
        this.frozenMass = builder.frozenMass;
        this.milk = builder.milk;
        this.juice = builder.juice;
        this.water = builder.water;
        this.type = builder.type;
    }

    public String getCommand() {
        return String.format("%dg %dml %dml %dml", frozenMass, milk, juice, water);
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private int frozenMass;
        private int milk;
        private int juice;
        private int water;
        private String type = "unknown";

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder frozenMass(int frozenMass) {
            this.frozenMass = frozenMass;
            return this;
        }

        public Builder milk(int milk) {
            this.milk = milk;
            return this;
        }

        public Builder juice(int juice) {
            this.juice = juice;
            return this;
        }

        public Builder water(int water) {
            this.water = water;
            return this;
        }

        public Dessert build() {
            return new Dessert(this);
        }
    }
}
