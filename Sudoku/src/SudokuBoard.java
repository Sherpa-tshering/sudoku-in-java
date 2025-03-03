import javax.swing.*;
//import java.awt.*;

public class SudokuBoard {
    public SudokuBoard(JPanel boardPanel, String[] puzzle, String[] solution, SudokuGame game) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Tile tile = new Tile(r, c, puzzle[r].charAt(c), solution[r].charAt(c), game);
                boardPanel.add(tile);
            }
        }
    }
}
