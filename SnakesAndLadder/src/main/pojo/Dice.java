package main.pojo;

import java.util.Random;

public class Dice {
    private int noOfDice;
    Random random = new Random();

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice() {
        return random.nextInt(this.noOfDice * 6 - this.noOfDice) + this.noOfDice;
    }
}
