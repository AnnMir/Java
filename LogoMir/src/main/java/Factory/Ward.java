package Factory;

import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;

class Ward extends Worker
{
    public Ward() {}
    public void execute(String[] args, GameField gameField) throws MyException
    {
        checkInit(gameField);
        if (args != null)
        {
            throw new InvalidArgs(Ward.class.getName());
        }
        if(gameField.getTurtle().isDraw())
            gameField.getTurtle().setDraw();
    }
}