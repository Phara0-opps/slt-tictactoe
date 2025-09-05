
public class Board {
    private final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    // Setzt alle Felder auf leer
    public void clear() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    // Gibt das Spielfeld in der Konsole aus
    public void print() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                char c = cells[i][j] == ' ' ? ' ' : cells[i][j];
                System.out.print(c);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    // Snapshot des Spielfelds (für Auswertung / Tests)
    public char[][] snapshot() {
        char[][] s = new char[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                s[i][j] = cells[i][j];
            }
        }
        return s;
    }
}