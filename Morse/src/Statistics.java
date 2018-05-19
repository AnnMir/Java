import java.util.Map;

public class Statistics {
    public static void stat(String sumb, Map<String,Integer> st){
        if(st.containsKey(sumb.toString())) {
            Integer tmp = st.get(sumb.toString());
            tmp += 1;
            st.put(sumb.toString(), tmp);
        }
    }
}
