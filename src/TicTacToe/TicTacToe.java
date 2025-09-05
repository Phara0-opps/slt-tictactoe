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

            // Spieler wechseln
            switchCurrentPlayer();
        }

        sc.close();
        System.out.println("Game ended.");
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Platzhalter für später
    public boolean hasWinner() {
        return false;
    }
}
