package view.FieldForCommand;

import java.util.Arrays;
import java.util.EventObject;

public class CommandLineEvent extends EventObject
{
    private String command;
    private String[] arguments = null;
    public CommandLineEvent(Object source, String args)
    {
        super(source);
        String[] argsArray = args.split("\\s+");
        command = argsArray[0];
        if (argsArray.length > 1)
        {
            arguments = Arrays.copyOfRange(argsArray, 1, argsArray.length);
        }
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }
}