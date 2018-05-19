import java.io.*;
import java.util.Map;

public class Coder {

    public static void code(BufferedReader reader, Map<String, String> map,FileWriter file,Map<String,Integer> statistic) {
        String str;
        StringBuilder Out = new StringBuilder();
        Statistics st = new Statistics();

        try{
            FileWriter statinfo = new FileWriter("stat.txt");
        while((str = reader.readLine()) != null) {
            str = str.toUpperCase();

            for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            Character c = ch;
            if (map.containsKey(c.toString())) {
                Out.append(map.get(c.toString()));
                Out.append(" ");
                st.stat(c.toString(),statistic);
            }
            if (c == 32){
                Out.append("       ");
            }
            }
            Out.append("\r\n");
        }
            file.write(Out.toString());
        file.flush();
        for(Map.Entry<String,Integer> tmp: statistic.entrySet()){
            statinfo.write(tmp.getKey());
            statinfo.write(" ");
            statinfo.write(String.valueOf(tmp.getValue()));
            statinfo.write("\r\n");
        }
            statinfo.flush();
    }
    catch(IOException exception){
        System.err.println("Error of Coder");
        }
    }
}
