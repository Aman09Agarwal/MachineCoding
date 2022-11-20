package main.model.split;

import main.model.User;

public class PercentSplit extends Split{
    double percent;
    public PercentSplit(User borrower, double percent) {
        super(borrower);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
