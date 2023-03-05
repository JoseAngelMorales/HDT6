package HDT6;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Mapa {
    Map<String, String> mapa;
    
    public Map<String, String> newMap(int i){

        switch(i){
            case 1:
                mapa = new HashMap<String, String>();
            case 2:
                mapa = new LinkedHashMap<String, String>();
            case 3:
                mapa = new TreeMap<String, String>();
        }
        return mapa;   
    }
}
