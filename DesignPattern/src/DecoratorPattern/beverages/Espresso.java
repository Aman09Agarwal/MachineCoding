package DecoratorPattern.beverages;

public class Espresso extends Beverage{
    public Espresso() {
        beverageName = "Espresso coffee";
    }

    @Override
    public double getBeveragePrice() {
        return 10;
    }
}
