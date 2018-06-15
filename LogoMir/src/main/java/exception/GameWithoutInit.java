package exception;

import javax.swing.*;

public class GameWithoutInit extends MyException
{
    @Override
    public void printException()
    {
        JOptionPane.showMessageDialog(null,"You can't play without initialize field","WARNING!",JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public String getMessage() {
        return "You can't play without initialize field";
    }
}
