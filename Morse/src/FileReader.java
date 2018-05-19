import java.io.*;

public class FileReader {
    public static BufferedReader read(String filename) throws NullPointerException {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        }
        catch(IOException exception){
            System.err.println("Error of FileReader(read)");
        }
        catch(NullPointerException exception){
            System.err.println("NullPointerException");
        }
        return reader;
    }
    public static void close(BufferedReader reader) {
        try {
            if (reader != null) reader.close();
        } catch(IOException exception) {
            System.err.println("Error jf FileReader(close)");
        }
    }
}