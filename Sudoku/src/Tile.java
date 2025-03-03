import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile extends JButton {
    public int row, col;
    public char correctValue;
    public SudokuGame game;

    public Tile(int row, int col, char value, char correctValue, SudokuGame game) {
        this.row = row;
        this.col = col;
        this.correctValue = correctValue;
        this.game = game;

        setFont(new Font("Arial", Font.PLAIN, 20));
        setBackground(value == '-' ? Color.WHITE : Color.LIGHT_GRAY);
        setText(value == '-' ? "" : String.valueOf(value));
        setFocusable(false);

        // Styling the grid to have bold borders in 3x3 blocks
        int top = 1, left = 1, bottom = (row % 3 == 2) ? 5 : 1, right = (col % 3 == 2) ? 5 : 1;
        setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

        if (value == '-') {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton numSelected = game.getNumSelected();
                    if (numSelected != null) {
                        if (!getText().isEmpty()) return;
                        String selectedValue = numSelected.getText();
                        if (selectedValue.equals(String.valueOf(correctValue))) {
                            setText(selectedValue);
                        } else {
                            game.incrementErrors();
                        }
                    }
                }
            });
        }
    }
}
