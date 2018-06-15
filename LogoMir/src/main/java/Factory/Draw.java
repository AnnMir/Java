package Factory;

import exception.InvalidArgs;
import exception.MyException;
import view.FieldForGame.GameField;

class Draw extends Worker
{
    public Draw() {}
    public void execute(String[] args, GameField gameField) throws MyException
    {
        checkInit(gameField);
        if (args != null)
        {
            throw new InvalidArgs(Draw.class.getName());
        }
        if(!gameField.getTurtle().isDraw())
            gameField.getTurtle().setDraw();
    }
}