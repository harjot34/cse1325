package emporium;

import java.util.HashSet;
import java.util.HashMap;

public class MultiMap<K, V> {

    private HashMap<K, HashSet<V>> map = new HashMap<>();

    public void put(K key, V value) {
        if (map.get(key) == null) {
            map.put(key, new HashSet<V>());
        }
        map.get(key).add(value);
    }

    public Object[] get(Object key) {
        return map.get(key) == null ? new Object[0] : map.get(key).toArray();
    }

}
