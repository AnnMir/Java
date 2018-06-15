package Factory;

import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;


class Move extends Worker
{
    public Move() {}
    public void execute(String[] args, GameField gameField) throws MyException
    {
        checkInit(gameField);
        if (args == null || args.length != 2)
        {
            throw new InvalidArgs(Move.class.getName());
        }
        checkArguments(Move.class.getName(), new String[] { args[1] });

        int length = Integer.parseInt(args[1]);
        char direction = args[0].charAt(0);
        gameField.getTurtle().rem_turt();
        for(int i=0;i<length;i++)
        {
            gameField.moveTurtle(direction);
        }
        gameField.getTurtle().load_turt();
    }
}
