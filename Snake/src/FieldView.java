import javax.swing.*;
import java.awt.*;

public class FieldView {
    public void setUpGui(GameField snakeField, ScorePanel scorePanel) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.getContentPane().add(BorderLayout.CENTER, snakeField);
        mainFrame.getContentPane().add(BorderLayout.EAST, scorePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
