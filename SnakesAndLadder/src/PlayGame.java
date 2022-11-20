import main.pojo.*;
import main.service.GameBoard;

import java.io.IOException;
import java.util.*;

public class PlayGame {
    public static void main(String []args) throws IOException, Exception {
        Dice dice = new Dice(1);
        Player p1 = new Player("Mike",1);
        Player p2 = new Player("John",2);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        Jumper snake1 = new Snake(10,2);
        Jumper snake2 = new Snake(99,12);
        List<Jumper> snakes = new ArrayList<>(Arrays.asList(snake1,snake2));
        Jumper ladder1 = new Ladder(5,25);
        Jumper ladder2 = new Ladder(40,89);
        List<Jumper> ladders = new ArrayList<>(Arrays.asList(ladder1,ladder2));
        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Mike",0);
        playersCurrentPosition.put("John",0);
        GameBoard gb=new GameBoard(dice,allPlayers,snakes,ladders,playersCurrentPosition,100);
        gb.startGame();
    }
}
