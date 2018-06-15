package exception;

import javax.swing.*;

public class InvalidConfigFile extends MyException
{
    private String commandName;
    public InvalidConfigFile(String name)
    {
        commandName =name;
    }
    @Override
    public void printException()
    {
        JOptionPane.showMessageDialog(null,"Wrong config file: "+ commandName,"WARNING!",JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public String getMessage() {
        return "Wrong config file: "+ commandName;
    }
}
