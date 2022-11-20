package main.model.expense;

import main.model.User;
import main.model.split.PercentSplit;
import main.model.split.Split;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(double amount, User lender, List<Split> splits, ExpenseDetails expenseDetails) {
        super(amount, lender, splits, expenseDetails);
    }

    public boolean validate() {
        double totalSplitPercent = 0;
        for(Split split : getSplits()) {
            if(!(split instanceof PercentSplit))
                return false;
            totalSplitPercent += ((PercentSplit) split).getPercent();
        }
        return totalSplitPercent == 100;
    }
}
