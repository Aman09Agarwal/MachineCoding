package DecoratorPattern;

import DecoratorPattern.beverages.Beverage;
import DecoratorPattern.beverages.Espresso;
import DecoratorPattern.ingredients.Caramel;
import DecoratorPattern.ingredients.Milk;

public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());

        System.out.println("After decorating with milk");
        beverage = new Milk(beverage);
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());

        System.out.println("After decorating with double caramel");
        beverage = new Caramel(beverage);
        beverage = new Caramel(beverage);
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
    }
}
