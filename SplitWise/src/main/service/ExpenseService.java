package main.service;

import main.enums.ExpenseType;
import main.model.User;
import main.model.expense.*;
import main.model.split.PercentSplit;
import main.model.split.Split;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User lender, List<Split> splits, ExpenseDetails expenseDetails) {
        switch(expenseType) {
            case EXACT :
                return new ExactExpense(amount, lender, splits, expenseDetails);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = amount/totalSplits;
                for(Split split : splits) {
                    split.setAmount(splitAmount);
                }
                return new EqualExpense(amount, lender, splits, expenseDetails);
            case PERCENT:
                for(Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100);
                }
                return new PercentExpense(amount, lender, splits, expenseDetails);
            default:
                return null;
        }
    }
}
