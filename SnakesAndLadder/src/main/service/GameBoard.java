package main.service;

import main.pojo.Dice;
import main.pojo.Jumper;
import main.pojo.Player;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playerCurrentPosition;
    private int boardSize;

    public GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders, Map<String, Integer> playerCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while(nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playerCurrentPosition.get(player.getName());
            int diceValue = dice.rollDice();
            int nextPosition = currentPosition + diceValue;
            if(nextPosition > boardSize)    nextTurn.offer(player);
            else if(nextPosition == boardSize)  System.out.println(player.getName()+" won the game!!");
            else continueGame(nextPosition, player);
        }
    }

    private void continueGame(int nextPosition, Player player) {
        int nextCell = checkBittenBySnake(nextPosition, player);
        if(nextCell == nextPosition) {
            nextCell = checkForLadder(nextPosition, player);
        }
        if(nextCell == boardSize)   System.out.println(player.getName()+" won the game!!");
        else {
            playerCurrentPosition.put(player.getName(), nextCell);
            System.out.println(player.getName()+" is at position "+nextCell);
            nextTurn.offer(player);
        }
    }

    private int checkBittenBySnake(int nextPosition, Player player) {
        int nextCell = nextPosition;
        for(Jumper snake : snakes) {
            if(snake.getStart() == nextCell){
                nextCell = snake.getEnd();
                System.out.println(player.getName()+" bitten by snake at "+nextPosition+"   SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
                break;
            }
        }
        return nextCell;
    }

    private int checkForLadder(int nextPosition, Player player) {
        int nextCell = nextPosition;
        for(Jumper ladder : ladders) {
            if(ladder.getStart() == nextCell){
                nextCell = ladder.getEnd();
                System.out.println(player.getName()+" got a ladder at "+nextPosition+"  /=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
                break;
            }
        }
        return nextCell;
    }
}
