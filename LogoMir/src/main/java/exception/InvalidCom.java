package exception;

import javax.swing.*;

public class InvalidCom extends MyException
{
    private String commandName;
    public InvalidCom(String name)
    {
        commandName = name;
    }

    @Override
    public void printException()
    {
        JOptionPane.showMessageDialog(null,"Wrong command "+ commandName,"WARNING!",JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public String getMessage() {
        return "Wrong command "+ commandName;
    }
}
