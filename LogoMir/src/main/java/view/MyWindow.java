package view;

import exception.*;
import view.FieldForCommand.ComField;
import view.FieldForCommand.CommandLineEvent;
import view.FieldForCommand.CommandLineListener;
import view.FieldForGame.GameField;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame
{
    private ComField commandfield;
    private GameField gamefield;
    private static final Logger log = Logger.getLogger(MyWindow.class);
    MyWindow(String title)
    {
        super(title);
        setLayout(new BorderLayout());
        gamefield=new GameField();
        //ComField comField=new ComField(gamefield);
        commandfield =new ComField(gamefield);
        commandfield.addCommandLineListener(new CommandLineListener()
        {
            @Override
            public void commandLineEventOccurred(CommandLineEvent e)
            {
                try
                {
                    gamefield.action_job(e.getCommand(), e.getArguments());
                }
                catch (InvalidArgs | InvalidCom | GameWithoutInit | InvalidConfigFile exception)
                {
                    log.warn(exception.getMessage());
                    exception.printException();
                }
                catch (MyException ex)
                {
                    System.err.println("Unknown exception "+ex.getMessage());
                }
            }
        });
        //System.out.printf(""+gamefield.equals(comField));
        add(commandfield,BorderLayout.SOUTH);
        add(gamefield,BorderLayout.CENTER);
    }
}
