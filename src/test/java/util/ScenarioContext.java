package util;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScenarioContext {

    private static final Map<DataKey,Object> storage=new HashMap();

    public ScenarioContext(){
    }
    public static void saveData(DataKey key, Object value){
        storage.put(key, value);
    }

    public static Object getData(DataKey key){return storage.get(key);}
    public Set<DataKey> getDataKeys(){return storage.keySet();}
    public void resetContext(){storage.clear();}
}
