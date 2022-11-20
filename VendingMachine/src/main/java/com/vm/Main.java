package com.vm;

import com.vm.vendingStates.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("filling up the inventory ...");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("clicking on insert coin button");
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.DIME);
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("clicking on product selection button");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch(Exception e) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i=0; i<slots.length; i++) {
            Item newItem = new Item();
            if(i>=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i>=3 && i<5) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i>=5 && i<7) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            } else {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(ItemShelf itemShelf : slots) {
            System.out.println("codeNumber : " + itemShelf.getCode() +
                                " item : " + itemShelf.getItem().getType().name() +
                                " price : " + itemShelf.getItem().getPrice() +
                                " isAvailable : " + !itemShelf.isSoldOut());
        }
    }
}
