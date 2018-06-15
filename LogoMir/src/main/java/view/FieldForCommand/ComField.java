package view.FieldForCommand;

import view.FieldForGame.GameField;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.*;


public class ComField extends JPanel
{
    public EventListenerList listenerList = new EventListenerList();

    JTextField commandField=null;
    JButton executeButton=null;
    JButton clearButton=null;
    public ComField(final GameField field)
    {
        Dimension size = getPreferredSize();
        size.height = 35;
        setPreferredSize(size);
        Font font=new Font("TimesRoman",Font.BOLD,12);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JLabel commandLabel = new JLabel("  Command:");
        commandLabel.setPreferredSize(new Dimension(85, 20));
        commandLabel.setFont(font);

        commandField = new JTextField();
        commandField.setPreferredSize(new Dimension(95, 20));
        commandField.setFont(font);


        executeButton = new JButton();
        executeButton.setPreferredSize(new Dimension(85, 20));
        executeButton.setFont(font);
        executeButton.setText("Execute");

        clearButton = new JButton();
        clearButton.setPreferredSize(new Dimension(85, 20));
        clearButton.setFont(font);
        clearButton.setText("Clear");

        gc.gridx = 2;
        gc.gridy = 0;
        add(commandField, gc);

        gc.gridx=0;
        gc.gridy=0;
        add(clearButton,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(commandLabel, gc);

        gc.gridx = 3;
        gc.gridy = 0;
        add(executeButton, gc);

        clearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                field.clear();
            }
        });

        executeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fireCommandLineEvent(new CommandLineEvent(this, commandField.getText().toUpperCase().trim()));
                commandField.setText("");
            }
        });
        /*executeButton.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode()== KeyEvent.VK_DOWN)
                {
                    fireCommandLineEvent(new CommandLineEvent(this, "MOVE D 1"));
                    commandField.setText("");
                }
                if (e.getKeyCode()== KeyEvent.VK_UP)
                {
                    fireCommandLineEvent(new CommandLineEvent(this, "MOVE U 1"));
                    commandField.setText("");
                }
                if (e.getKeyCode()== KeyEvent.VK_LEFT)
                {
                    fireCommandLineEvent(new CommandLineEvent(this, "MOVE L 1"));
                    commandField.setText("");
                }
                if (e.getKeyCode()== KeyEvent.VK_RIGHT)
                {
                    fireCommandLineEvent(new CommandLineEvent(this, "MOVE R 1"));
                    commandField.setText("");
                }

            }
        });*/
        commandField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    fireCommandLineEvent(new CommandLineEvent(this, commandField.getText().toUpperCase().trim()));
                    commandField.setText("");
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    private void fireCommandLineEvent(CommandLineEvent e)
    {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i +=2)
        {
            if (listeners[i] == CommandLineListener.class)
            {
                ((CommandLineListener)listeners[i + 1]).commandLineEventOccurred(e);
            }
        }

    }

    public void addCommandLineListener(CommandLineListener listener)
    {
        listenerList.add(CommandLineListener.class, listener);
    }
}
