package TicTacToe;

public class Board {
    private final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public boolean place(int x, int y, char marker) {
        if (x < 0 || x > 2 || y < 0 || y > 2) return false; // außerhalb
        if (!isCellEmpty(x, y)) return false;               // schon belegt
        cells[x][y] = marker;
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = cells[i][j] == ' ' ? ' ' : cells[i][j];
                System.out.print(c);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public char[][] snapshot() {
        char[][] copy = new char[3][3];
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                copy[i][j] = cells[i][j];
            }
        }
        return copy;
    }
}
