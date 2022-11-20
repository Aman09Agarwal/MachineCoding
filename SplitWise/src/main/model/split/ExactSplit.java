package main.model.split;

import main.model.User;

public class ExactSplit extends Split{
    public ExactSplit(User borrower, double amount) {
        super(borrower);
        this.amount = amount;
    }
}
