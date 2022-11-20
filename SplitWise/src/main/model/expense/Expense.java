package main.model.expense;

import main.model.User;
import main.model.split.Split;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
    private final String id;
    private double amount;
    private User lender;
    private List<Split> splits;
    private ExpenseDetails expenseDetails;

    public Expense(double amount, User lender, List<Split> splits, ExpenseDetails expenseDetails) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.lender = lender;
        this.splits = splits;
        this.expenseDetails = expenseDetails;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseDetails getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(ExpenseDetails expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public abstract boolean validate();
}
