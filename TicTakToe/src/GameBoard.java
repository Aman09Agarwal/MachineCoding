import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameBoard {
    char[][] board;
    int boardSize;
    Queue<Player> nextTurn;
    Scanner input;

    public GameBoard(int boardSize, Player[] players) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        initializeBoard(board, this.boardSize);
        nextTurn = new LinkedList<>();
        for(Player player : players) {
            nextTurn.offer(player);
        }
        input = new Scanner(System.in);
    }

    private void initializeBoard(char[][] board, int boardSize) {
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void startGame() {
        int count = 0;
        while(true) {
            count++;
            if(count > boardSize*boardSize)
                break;
            Player p = nextTurn.poll();
            int position = getUserInput(p);
            int row = position%boardSize==0 ? (position/boardSize)-1 : position/boardSize;
            int col = position%boardSize==0 ? boardSize-1 : (position%boardSize)-1;
            printBoard();
            board[row][col] = p.getSymbol();
            System.out.println("Board after the move");
            if(count >= boardSize*2 - 1 && checkEndGame(p,row,col)) break;
            nextTurn.offer(p);
        }
    }

    private int getUserInput(Player p) {
        printBoard();
        System.out.println(p.getName()+" >>> please enter a number between 1 and "+boardSize*boardSize);
        int val = input.nextInt();
        while(!validateInput(val)) {
            printBoard();
            System.out.println("Invalid input : "+p.getName()+" >>> please enter a number between 1 and "+boardSize*boardSize);
            val = input.nextInt();
        }
        return val;
    }

    private boolean validateInput(int val) {
        if(val<1 || val>boardSize*boardSize) return false;
        int row = val%boardSize==0 ? (val/boardSize)-1 : val/boardSize;
        int col = val%boardSize==0 ? boardSize-1 : (val%boardSize)-1;
        if(board[row][col] != '-') return false;
        return true;
    }

    private boolean checkEndGame(Player p, int row, int col) {
        StringBuilder winString = new StringBuilder();
        for(int i=0; i<boardSize; i++) {
            winString.append(p.getSymbol());
        }

        StringBuilder rowString = new StringBuilder();
        StringBuilder colString = new StringBuilder();
        StringBuilder diagonalString = new StringBuilder();
        StringBuilder revDiagonalString = new StringBuilder();

        for(int i=0; i<boardSize; i++) {
            rowString.append(board[row][i]);
            colString.append(board[i][col]);
            if(row == col) {
                diagonalString.append(board[i][i]);
            }
            if(row+col == boardSize-1) {
                revDiagonalString.append(board[i][boardSize-i-1]);
            }
        }

        if(rowString.toString().equals(winString.toString()) ||
                colString.toString().equals(winString.toString()) ||
                diagonalString.toString().equals(winString.toString()) ||
                revDiagonalString.toString().equals(winString.toString())) {
            printBoard();
            System.out.println(p.getName()+" has won the game");
            return true;
        }
        return false;
    }
}
