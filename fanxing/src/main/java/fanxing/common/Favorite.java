package fanxing.common;

import java.util.HashMap;
import java.util.Map;

public class Favorite {

    private Map<Class<?>,Object> map = new HashMap<Class<?>,Object>();


    public <T> void putFavorite(Class<T> type,T instance){

        if(type == null){
            throw new NullPointerException();
        }
        map.put(type, instance);
    }

    public <T> T getFavorites(Class<T> type){
        return type.cast(map.get(type));
    }

}
