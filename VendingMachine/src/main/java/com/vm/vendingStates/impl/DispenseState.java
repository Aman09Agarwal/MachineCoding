package com.vm.vendingStates.impl;

import com.vm.Coin;
import com.vm.Item;
import com.vm.VendingMachine;
import com.vm.vendingStates.State;

import java.util.List;

public class DispenseState implements State {
    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently machine is in dispense state");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Insert coin button cannot be clicked in dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Product selection button cannot be clicked in dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("coin cannot be inserted in dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product cannot be chosen in dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("change cannot be returned in dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("refund cannot happen in dispense state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) throws Exception {
        throw new Exception("Inventory cannot be updated in dispense state");
    }
}
