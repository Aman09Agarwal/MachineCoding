package main.model.expense;

import main.model.User;
import main.model.split.ExactSplit;
import main.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User lender, List<Split> splits, ExpenseDetails expenseDetails) {
        super(amount, lender, splits, expenseDetails);
    }

    public boolean validate() {
        double totalAmount = getAmount();
        double totalSplitAmount = 0;
        for(Split split : getSplits()) {
            if(!(split instanceof ExactSplit))
                return false;
            totalSplitAmount += split.getAmount();
        }
        return totalSplitAmount == totalAmount;
    }
}
