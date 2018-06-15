package Factory;

import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;

class Teleport extends Worker
{
    public Teleport() {}
    public void execute(String[] args, GameField gameField) throws MyException
    {
        checkInit(gameField);
        checkArguments(Teleport.class.getName(), args);
        if (args == null || args.length != 2)
        {
            throw new InvalidArgs(Teleport.class.getName());
        }
        gameField.putTurtle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
