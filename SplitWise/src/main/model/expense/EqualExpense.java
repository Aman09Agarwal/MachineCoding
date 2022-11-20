package main.model.expense;

import main.model.User;
import main.model.split.EqualSplit;
import main.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User lender, List<Split> splits, ExpenseDetails expenseDetails) {
        super(amount, lender, splits, expenseDetails);
    }

    public boolean validate() {
        for(Split split : getSplits()) {
            if(!(split instanceof EqualSplit))
                return false;
        }
        return true;
    }
}
