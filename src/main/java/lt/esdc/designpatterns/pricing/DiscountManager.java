package lt.esdc.designpatterns.pricing;

public enum DiscountManager {

    NONE {
        @Override
        public double apply(double total) {
            return total;
        }
    },
    STUDENT {
        @Override
        public double apply(double total) {
            return total * 0.8;
        }
    },
    LOYALTY {
        @Override
        public double apply(double total) {
            return total * 0.9;
        }
    };

    public abstract double apply(double total);
}
