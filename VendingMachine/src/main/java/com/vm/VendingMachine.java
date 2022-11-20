package com.vm;

import com.vm.vendingStates.impl.IdleState;
import lombok.Data;
import com.vm.vendingStates.State;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(){
        vendingMachineState = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }
}
