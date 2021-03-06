import java.util.*;

public class Food {
    private GameField snakeField;
    private int size = SnakeBody.CELL_SIZE;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void SetGameField(GameField snakefield){
        snakeField = snakefield;
    }

    public void generateFood(ArrayList<SnakeCell> snakeList) {
        boolean loop = true;
        while(loop) {
            x = (int)(Math.random() * GameWindow.WINDOW_WIDTH) / SnakeBody.CELL_SIZE * SnakeBody.CELL_SIZE;
            y = (int)(Math.random() * GameWindow.WINDOW_HEIGHT) / SnakeBody.CELL_SIZE * SnakeBody.CELL_SIZE;
            loop = false;
            //checks if generated food appeared inside snake body
            for(SnakeCell cell: snakeList) {
                if (this.equals(cell)) {
                    loop = true;
                }
            }
        }
        snakeField.Change();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj.getClass() == SnakeCell.class)) return false;
        SnakeCell cell = (SnakeCell) obj;
        return x == cell.getX() && y == cell.getY();
    }

    public int hashCode() {
        return x + y;
    }
}