package lt.esdc.designpatterns.pipeline;

import lt.esdc.designpatterns.factory.DessertFactory;

public class OrderPipeline {

    private final DessertFactory factory;

    public OrderPipeline(DessertFactory factory) {
        this.factory = factory;
    }

    public OrderContext execute(OrderContext ctx) {

        for (OrderStep step : OrderStep.values()) {
            step.process(ctx, factory);
        }

        return ctx;
    }
}