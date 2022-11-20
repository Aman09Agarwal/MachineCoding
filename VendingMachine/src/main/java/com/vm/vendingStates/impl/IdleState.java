package com.vm.vendingStates.impl;

import com.vm.Coin;
import com.vm.Item;
import com.vm.VendingMachine;
import com.vm.vendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState() {
        System.out.println("Currently machine is in idle state");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently machine is in idle state");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you cannot insert coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you cannot choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you cannot get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product cannot be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you cannot get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) throws Exception {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
