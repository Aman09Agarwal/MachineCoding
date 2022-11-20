package main.service;

import main.enums.ExpenseType;
import main.model.expense.ExpenseDetails;
import main.model.split.Split;
import main.repository.ExpenseRepository;

import java.util.List;

public class SplitWiseService {
    ExpenseRepository expenseRepository;

    public SplitWiseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(ExpenseType expenseType, double amount, String lender, List<Split> splits, ExpenseDetails expenseDetails) {
        expenseRepository.addExpense(expenseType, amount, lender, splits, expenseDetails);
    }

    public void showBalance(String userName) {
        List<String> balanceList = expenseRepository.getBalance(userName);
        if(balanceList.isEmpty()) {
            System.out.println("No balance");
        } else {
            for(String balance : balanceList) {
                System.out.println(balance);
            }
        }
    }

    public void showAllBalance() {
        List<String> balanceList = expenseRepository.getAllBalance();
        if(balanceList.isEmpty()) {
            System.out.println("No balance");
        } else {
            for(String balance : balanceList) {
                System.out.println(balance);
            }
        }
    }
}
