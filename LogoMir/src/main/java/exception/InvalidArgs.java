package exception;

import javax.swing.*;

public class InvalidArgs extends MyException
{
    private String className;
    public InvalidArgs(String name)
    {
        className =name;
    }
    @Override
    public void printException()
    {
        JOptionPane.showMessageDialog(null, "Wrong arguments in '" + className, "WARNING!", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public String getMessage()
    {
     return "Wrong arguments in '" + className+"'";
    }
}
