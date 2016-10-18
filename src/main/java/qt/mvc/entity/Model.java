package qt.mvc.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiutian on 16-9-13.
 */
public class Model {

    private Map<String,Object> map;

    public  Model(){
       map = new HashMap<String,Object>();
    }

    public void add(String key,Object val){
        map.put(key,val);
    }

    public Object get(String key){
        return map.get(key);
    }

    public Map<String,Object> getMap(){
        return map;
    }

    public int size(){
        return map.size();
    }
}
