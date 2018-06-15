package Factory;

import exception.GameWithoutInit;
import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;

public abstract class Worker
{
    public abstract void execute(String[] args, GameField gameField) throws MyException;

    protected void checkInit(GameField gameField) throws MyException
    {
        if(gameField.isEmpty())
            throw new GameWithoutInit();
    }

    protected void checkArguments(String commandName, String[] arguments) throws MyException
    {
        try
        {
            for (String arg : arguments)
            {
                if (Integer.parseInt(arg) < 0)
                {
                    throw new InvalidArgs(commandName);
                }
            }
        } catch (NumberFormatException ex)
        {
            throw new InvalidArgs(commandName);
        }
    }
}