package com.vm.vendingStates.impl;

import com.vm.Coin;
import com.vm.Item;
import com.vm.VendingMachine;
import com.vm.vendingStates.State;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Currently machine is in selection state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you cannot click on insert coin button in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you cannot insert coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()) {
            paidByUser += coin.value;
        }

        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient amount paid by user");
            refundFullMoney(machine);
            throw new Exception("Insufficient amount");
        } else {
            if(paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in coin dispense tray : " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in coin dispense tray");
        vendingMachine.setVendingMachineState(new IdleState());
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) throws Exception {
        throw new Exception("Inventory cannot be updated in selection state");
    }
}
