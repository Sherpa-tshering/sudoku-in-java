import javax.swing.*;
import java.awt.*;

public class SudokuGame {
    private JFrame frame;
    private JLabel textLabel;
    private JPanel boardPanel;
    private JPanel buttonsPanel;
    private JButton numSelected = null;
    private int errors = 0;
    private final String[] puzzle = {
            "--74916-5", "2---6-3-9", "-----7-1-",
            "-586----4", "--3----9-", "--62--187",
            "9-4-7---2", "67-83----", "81--45---"
    };
    private final String[] solution = {
            "387491625", "241568379", "569327418",
            "758619234", "123784596", "496253187",
            "934176852", "675832941", "812945763"
    };

    public SudokuGame() {
        frame = new JFrame("Sudoku");
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Title
        textLabel = new JLabel("Sudoku: 0", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel textPanel = new JPanel();
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        // Game board
        boardPanel = new JPanel(new GridLayout(9, 9));
        SudokuBoard sudokuBoard = new SudokuBoard(boardPanel, puzzle, solution, this);
        frame.add(boardPanel, BorderLayout.CENTER);

        // Number selection buttons
        buttonsPanel = new JPanel(new GridLayout(1, 9));
        new SudokuButtons(buttonsPanel, this);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public JButton getNumSelected() {
        return numSelected;
    }

    public void setNumSelected(JButton numSelected) {
        this.numSelected = numSelected;
    }

    public void incrementErrors() {
        errors++;
        textLabel.setText("Sudoku: " + errors);
    }
}
