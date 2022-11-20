package DecoratorPattern.ingredients;

import DecoratorPattern.beverages.Beverage;

public abstract class IngredientDecorator extends Beverage {
    public abstract String getBeverageName();
}
