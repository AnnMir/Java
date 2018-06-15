package Factory;

import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;

class Init extends Worker
{
    private static final int min_cols = 4;
    private static final int min_rows = 4;
    private static final int max_cols = 9;
    private static final int max_rows = 9;

    public Init() {}
    public void execute(String[] args, GameField gameField) throws MyException
    {
        if (args == null || args.length != 2 && args.length != 4)
        {
             throw new InvalidArgs(Init.class.getName());
        }
        checkArguments(Init.class.getName(), args);

        if (args.length == 2)
        {
            if(!gameField.isEmpty())
            {
                gameField.clear();
                gameField.getTurtle().rem_turt();
                gameField.putTurtle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                return;
            }
            else
            {
                gameField.initCells(max_cols, max_rows);
                gameField.putTurtle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            }
        }

        if (args.length == 4)
        {
            if(!gameField.isEmpty())
            {
                gameField.deleteListOfCell();
            }
            int columns = Integer.parseInt(args[0]);
            int rows = Integer.parseInt(args[1]);
            if (columns < min_cols || columns > max_cols || rows < min_rows || rows > max_rows)
            {
                columns = max_cols;
                rows = max_rows;
            }
            gameField.initCells(columns, rows);
            gameField.putTurtle(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        }
    }
}