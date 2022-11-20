package DecoratorPattern.ingredients;

import DecoratorPattern.beverages.Beverage;

public class Milk extends IngredientDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getBeverageName() {
        return this.beverage.getBeverageName() + " with milk";
    }

    public double getBeveragePrice() {
        return this.beverage.getBeveragePrice() + 2;
    }
}
