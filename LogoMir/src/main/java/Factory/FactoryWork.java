package Factory;

import exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class FactoryWork
{

    private static Map<String, String> config = new TreeMap<>();
    private static Map<String, Worker> cache = new TreeMap<>();

    static //статический блок инициальзации
    {
        InputStream input = null;
        try
        {
            input = FactoryWork.class.getResourceAsStream("/res/config.csv");//считывание потоком из файла
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] args = line.split(",");
                config.put(args[0].toUpperCase(), args[1]);
            }
        }
        catch (IOException | NullPointerException e)
        {
            System.err.println(e.getLocalizedMessage());
        }
        finally
        {
            if (input != null)
            {
                try { input.close(); }
                catch (IOException e) { System.err.println(e.getLocalizedMessage()); }
            }
        }
    }

    public static Worker create(String command) throws MyException
    {
        String className = config.get(command);
        if (className == null)
        {
            throw new InvalidCom(command);
        }
        if (cache.containsKey(className))
        {
            return cache.get(className);
        }
        Worker worker = null;
        try
        {
            worker = (Worker)Class.forName("Factory." + className).newInstance();//порождение класса по его имени
            cache.put(className, worker);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
        {
            System.err.println(e.getLocalizedMessage());
            throw new InvalidConfigFile(command+","+className);
        }
        return worker;
    }
}

