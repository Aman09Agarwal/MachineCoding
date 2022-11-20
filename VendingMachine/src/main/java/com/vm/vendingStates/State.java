package com.vm.vendingStates;

import com.vm.Coin;
import com.vm.Item;
import com.vm.VendingMachine;

import java.util.List;

public interface State {
    void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    void updateInventory(VendingMachine vendingMachine, int codeNumber, Item item) throws Exception;
}
