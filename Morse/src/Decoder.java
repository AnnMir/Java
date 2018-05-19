import java.io.*;
import java.util.Map;

public class Decoder {
    public static void decode(BufferedReader reader, Map<String, String> reversemap, FileWriter file,Map<String,Integer> stat) {
        String str;
        String[] str1;
        String[] str2;
        StringBuilder Out = new StringBuilder();
        Statistics st = new Statistics();
        try {
            FileWriter statinfo = new FileWriter("stat.txt");
            while ((str = reader.readLine()) != null) {
                str1 = str.split("       ");

                for (int i = 0; i < str1.length; i++) {
                    str2 = str1[i].split(" ");
                    for(int j=0;j<str2.length;j++){
                    if (reversemap.containsKey(str2[j])) {
                        Out.append(reversemap.get(str2[j]));
                        st.stat(reversemap.get(str2[j]),stat);
                    }
                    }
                        Out.append(" ");

                }
                Out.append("\r\n");
                file.write(Out.toString());
                Out.delete(0,Out.length());
                file.flush();


            }
            for(Map.Entry<String,Integer> tmp: stat.entrySet()){
                statinfo.write(tmp.getKey());
                statinfo.write(" ");
                statinfo.write(String.valueOf(tmp.getValue()));
                statinfo.write("\r\n");
            }
            statinfo.flush();
        }
        catch (IOException exception) {
            System.err.println("Error of Decoder");
        }
    }
}
