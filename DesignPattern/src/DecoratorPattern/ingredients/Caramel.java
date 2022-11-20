package DecoratorPattern.ingredients;

import DecoratorPattern.beverages.Beverage;

public class Caramel extends IngredientDecorator {

    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getBeverageName() {
        return this.beverage.getBeverageName() + " with caramel";
    }

    public double getBeveragePrice() {
        return this.beverage.getBeveragePrice() + 5;
    }
}
