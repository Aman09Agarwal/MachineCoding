package com.vm.vendingStates.impl;

import com.vm.Coin;
import com.vm.Item;
import com.vm.VendingMachine;
import com.vm.vendingStates.State;

import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Currently machine is in has money state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you cannot get change in has money state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you cannot dispense product in has money state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the coin dispense tray");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) throws Exception {
        throw new Exception("you cannot update inventory in has money state");
    }
}
