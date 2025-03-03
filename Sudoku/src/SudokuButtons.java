import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuButtons {
    public SudokuButtons(JPanel buttonsPanel, SudokuGame game) {
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.WHITE);
            button.setFocusable(false);
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (game.getNumSelected() != null) {
                        game.getNumSelected().setBackground(Color.WHITE);
                    }
                    game.setNumSelected(button);
                    button.setBackground(Color.LIGHT_GRAY);
                }
            });
        }
    }
}
