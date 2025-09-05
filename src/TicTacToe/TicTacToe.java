package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Current Player: " + currentPlayer.getMarker());
            board.print();

            // US-3: Winner/Draw erkennen
            if (hasWinner()) {
                System.out.println("Winner: " + currentPlayer.getMarker());
                running = askNewGame(sc); // US-4
                continue;
            }
            if (board.isFull()) {
                System.out.println("Draw.");
                running = askNewGame(sc); // US-4
                continue;
            }

            // Eingabe Zug
            System.out.print("row (0-2): ");
            int x = Integer.parseInt(sc.nextLine().trim());
            System.out.print("column (0-2): ");
            int y = Integer.parseInt(sc.nextLine().trim());

            boolean placed = board.place(x, y, currentPlayer.getMarker());
            if (!placed) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            if (!hasWinner()) {
                switchCurrentPlayer();
            }
        }

        sc.close();
        System.out.println("Game ended.");
    }

    // US-4: Neustart
    private boolean askNewGame(Scanner sc) {
        System.out.print("New game? (y/n): ");
        String input = sc.nextLine().trim().toLowerCase();
        if (input.equals("y")) {
            board.clear();
            currentPlayer = player1; // X beginnt wieder
            return true;
        }
        return false;
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // US-3: Gewinnlogik
    public boolean hasWinner() {
        char[][] b = board.snapshot();
        for (char m : new char[]{'X','O'}) {
            for (int i=0; i<3; i++) {
                if (b[i][0]==m && b[i][1]==m && b[i][2]==m) return true; // Zeile
                if (b[0][i]==m && b[1][i]==m && b[2][i]==m) return true; // Spalte
            }
            if (b[0][0]==m && b[1][1]==m && b[2][2]==m) return true; // Diagonale
            if (b[0][2]==m && b[1][1]==m && b[2][0]==m) return true; // Gegen-Diagonale
        }
        return false;
    }
}