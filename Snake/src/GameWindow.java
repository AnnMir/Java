import java.awt.event.*;
import java.util.*;

public class GameWindow {
    public static final int WINDOW_WIDTH = 250;
    public static final int WINDOW_HEIGHT = 350;
    private Food food = new Food();
    private GameField snakeField;
    private SnakeBody snake;
    private ScorePanel scorePanel = new ScorePanel();

    private boolean allowToRestartTheGame = false;
    private boolean allowToMoveSnake = true;

    public void setUpGame() {
        int timeBetweenMoves = 190;                    //snake speed
        int scoreToChangeSpeedLevel = 100;

        FieldView fieldView = new FieldView();
        snake = new SnakeBody();
        snakeField = new GameField(snake.getCellList(), food, snake);
        snake.SetGameField(snakeField);
        food.SetGameField(snakeField);
        fieldView.setUpGui(snakeField,scorePanel);
        snakeField.addKeyListener(new GameWindow.SnakeKeyListener());
        food.generateFood(snake.getCellList());        //place food on the game field
        while (true) {
            if (!allowToMoveSnake) {                //if snake dead, wait for new game
                continue;
            }
            try {
                Thread.sleep(timeBetweenMoves);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            snake.move();
            checkIfSnakeGotFood();
            if ((scorePanel.getScore()) == scoreToChangeSpeedLevel) {
                timeBetweenMoves -= 20;
                scorePanel.incLevel(1);
                scoreToChangeSpeedLevel += 100;
            }
            if (snakeCollapsed()) {
                snakeField.Collapsed(scorePanel);
                allowToRestartTheGame = true;
                allowToMoveSnake = false;
                restartGame();
            }
        }
    }

    public void checkIfSnakeGotFood() {
        ArrayList<SnakeCell> cellList = snake.getCellList();
        SnakeCell cell = cellList.get(cellList.size() - 1);
        if (food.equals(cell)) {
            food.generateFood(snake.getCellList());
            cell.setSize(cell.getSize() + 2);
            cell.setX(cell.getX() - 1);
            cell.setY(cell.getY() - 1);
            scorePanel.incScore(10);
        }
    }

    public boolean snakeCollapsed() {
        ArrayList<SnakeCell> cellList = snake.getCellList();
        SnakeCell cell = cellList.get(cellList.size() - 1);
        Iterator itr = cellList.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(cell) && itr.hasNext()) {
                return true;
            }
        }
        return false;
    }


    public void restartGame() {
        allowToRestartTheGame = false;
        snake.reloadSnake();
        scorePanel.reloadPanel();
        allowToMoveSnake = true;
    }

    public class SnakeKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            snake.setSnakeDirection(e.getKeyCode());
        }
        public void keyReleased(KeyEvent e) { }
        public void keyTyped(KeyEvent e) { }
    }
}
