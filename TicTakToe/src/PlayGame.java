public class PlayGame {
    public static void main(String[] args) {
        Player p1 = new Player("John", 1, 'X');
        Player p2 = new Player("David", 2, 'O');
        Player[] players = new Player[]{p1,p2};
        GameBoard gb = new GameBoard(3,players);
        gb.startGame();
    }
}
