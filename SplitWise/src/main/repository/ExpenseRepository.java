package main.repository;

import main.enums.ExpenseType;
import main.model.User;
import main.model.expense.Expense;
import main.model.expense.ExpenseDetails;
import main.model.split.Split;
import main.service.ExpenseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    List<Expense> expenses;
    Map<String, User> userMap;
    Map<String, Map<String, Double>> balanceSheet;

    public ExpenseRepository() {
        this.expenses = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getName(), user);
        balanceSheet.put(user.getName(), new HashMap<>());
    }

    public User getUser(String userName) {
        return userMap.get(userName);
    }

    public void addExpense(ExpenseType expenseType, double amount, String lender, List<Split> splits, ExpenseDetails expenseDetails) {
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(lender), splits, expenseDetails);
        expenses.add(expense);
        if(null != expense) {
            for(Split split : expense.getSplits()) {
                String borrower = split.getUser().getName();

                Map<String, Double> balance = balanceSheet.get(lender);
                if(!balance.containsKey(borrower))
                    balance.put(borrower, 0.0);
                balance.put(borrower, balance.get(borrower) + split.getAmount());

                balance = balanceSheet.get(borrower);
                if(!balance.containsKey(lender))
                    balance.put(lender, 0.0);
                balance.put(lender, balance.get(lender) - split.getAmount());
            }
        }
    }

    private String checkSign(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if(amount<0) {
            return user1Name + " owes " + user2Name + " : " + Math.abs(amount);
        } else if(amount>0) {
            return user2Name + " owes " + user1Name + " : " + Math.abs(amount);
        } else {
            return "";
        }
    }

    public List<String> getBalance(String userName) {
        List<String> balance = new ArrayList<>();
        for(Map.Entry<String, Double> userBalance : balanceSheet.get(userName).entrySet()) {
            if(userBalance.getValue() != 0) {
                balance.add(checkSign(userName, userBalance.getKey(), userBalance.getValue()));
            }
        }
        return balance;
    }

    public List<String> getAllBalance() {
        List<String> balance = new ArrayList<>();
        for(String userName : balanceSheet.keySet()) {
            for(Map.Entry<String, Double> userBalance : balanceSheet.get(userName).entrySet()) {
                if(userBalance.getValue() > 0) {
                    balance.add(checkSign(userName, userBalance.getKey(), userBalance.getValue()));
                }
            }
        }
        return balance;
    }
}
