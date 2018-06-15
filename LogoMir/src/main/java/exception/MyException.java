package exception;

public abstract class MyException extends Exception
{
    abstract public void printException();

    @Override
    abstract public String getMessage();

}
