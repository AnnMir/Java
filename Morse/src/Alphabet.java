import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class Alphabet {

    public static void createMap(BufferedReader reader, Map<String, String> map, Map<String, String> reversemap,Map<String,Integer> st) {
        String line;
        try {
            while ((line = reader.readLine()) != null) {

                String args[] = line.split("\t");
                map.put(args[0],args[1]);
                reversemap.put(args[1],args[0]);
                st.put(args[0],0);
            }
        } catch (IOException exception) {
            System.err.println("Error from Alphabet");
        }
    }
}
