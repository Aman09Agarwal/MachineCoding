package com.vm;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public class Inventory {

    ItemShelf[] inventory = null;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    private void initializeEmptyInventory() {
        int startCode = 101;
        for(int i=0; i< inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode++);
            space.setSoldOut(true);
            inventory[i] = space;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber && itemShelf.isSoldOut()) {
                itemShelf.item = item;
                itemShelf.setSoldOut(false);
            } else {
                throw new Exception("Item is already present, you cannot add item here");
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        Optional<ItemShelf> itemShelfOptional = Arrays.stream(inventory).filter(x -> x.getCode() == codeNumber && !x.isSoldOut()).findFirst();
        if(itemShelfOptional.isPresent()) {
            return itemShelfOptional.get().getItem();
        }
        throw new Exception("Item already sold out");
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
