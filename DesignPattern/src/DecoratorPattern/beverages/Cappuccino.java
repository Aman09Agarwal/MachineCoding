package DecoratorPattern.beverages;

public class Cappuccino extends Beverage{
    public Cappuccino() {
        beverageName = "Cappuccino coffee";
    }

    @Override
    public double getBeveragePrice() {
        return 12;
    }
}
