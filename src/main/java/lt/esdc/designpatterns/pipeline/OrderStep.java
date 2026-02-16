package lt.esdc.designpatterns.pipeline;

import lt.esdc.designpatterns.factory.DessertFactory;
import lt.esdc.designpatterns.model.DessertInterface;
import lt.esdc.designpatterns.model.decorator.ChocolateDecorator;
import lt.esdc.designpatterns.model.decorator.MarshmallowDecorator;
import lt.esdc.designpatterns.model.decorator.SyrupDecorator;
import lt.esdc.designpatterns.pricing.DiscountManager;

public enum OrderStep {

    CREATE_DESSERT {
        @Override
        public void process(OrderContext ctx, DessertFactory factory) {
            if (ctx.rawInput.contains("icecream"))
                ctx.dessert = factory.createIceCream();
            else if (ctx.rawInput.contains("milkshake"))
                ctx.dessert = factory.createMilkshake();
            else
                ctx.dessert = factory.createSmoothie();
        }
    },

    APPLY_TOPPINGS {
        @Override
        public void process(OrderContext ctx, DessertFactory factory) {
            if (ctx.rawInput.contains("chocolate"))
                ctx.dessert = new ChocolateDecorator(ctx.dessert);

            if (ctx.rawInput.contains("marshmallow"))
                ctx.dessert = new MarshmallowDecorator(ctx.dessert);

            if (ctx.rawInput.contains("syrup"))
                ctx.dessert = new SyrupDecorator(ctx.dessert);
        }
    },

    APPLY_DISCOUNT {
        @Override
        public void process(OrderContext ctx, DessertFactory factory) {
            if (ctx.rawInput.contains("student"))
                ctx.discountManager = DiscountManager.STUDENT;
            else if (ctx.rawInput.contains("loyalty"))
                ctx.discountManager = DiscountManager.LOYALTY;
            else
                ctx.discountManager = DiscountManager.NONE;
        }
    };

    public abstract void process(OrderContext ctx, DessertFactory factory);
}