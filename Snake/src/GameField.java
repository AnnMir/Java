import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameField extends JPanel {
    private ArrayList<SnakeCell> snakeList;
    private Food food;
    private SnakeBody snakeBody;

    public GameField(ArrayList<SnakeCell> snake, Food snakeFood, SnakeBody snakeFrame) {
        snakeBody = snakeFrame;
        snakeList = snake;
        food = snakeFood;
        this.setFocusable(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(GameWindow.WINDOW_WIDTH,GameWindow.WINDOW_HEIGHT));
    }

    public void Collapsed(ScorePanel scorePanel){
        JOptionPane.showMessageDialog(null,"Game Over\n" +
                "Your level is: " + scorePanel.getLevel() + "  Your score is: " + scorePanel.getScore() + "\n" + "To restart the game, press ok button");
    }

    public void Change(){
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(SnakeCell cell: snakeList) {
            g.setColor(Color.YELLOW);
            g.fillRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
            g.setColor(Color.BLACK);
            g.drawRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
        }
        g.setColor(Color.RED);
        g.fillRect(food.getX(), food.getY(), food.getSize(), food.getSize());
    }
}