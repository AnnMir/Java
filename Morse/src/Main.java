import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        Map<String, String> reversemap = new HashMap<>();
        Map<String, Integer> stat = new HashMap<>();
        try{
            if (args.length != 4) {
                throw new IllegalArgumentException();
            }
            FileWriter file = new FileWriter(args[3]);
            BufferedReader reader = FileReader.read(args[2]);
            Alphabet.createMap(reader, map, reversemap,stat);
            FileReader.close(reader);
            BufferedReader reader1 = FileReader.read(args[1]);
            if (args[0].equals("code")) {
                Coder.code(reader1,map,file,stat);
            } else if (args[0].equals("decode")) {
                Decoder.decode(reader1,reversemap,file,stat);
            } else {
                throw new IOException();
            }
        }
        catch (FileNotFoundException except) { System.out.println("Please, check that your file exists");}
        catch (IOException except) { System.out.println("Please, write 'code' to code your text or 'decode' to decode your text and then text you want to change");}
        catch (IllegalArgumentException except){ System.out.println("Please, use this format: [code/decode] [file].txt");}
        catch(Exception except){ System.out.println("Something happened");}
        }
    }

