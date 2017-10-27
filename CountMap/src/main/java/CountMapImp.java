import java.util.HashMap;
import java.util.Map;

public class CountMapImp<E> implements CountMap<E> {
    private int size;
    private Map<E, Integer> map;

    public  CountMapImp() {
        this.size = 0;
        map = new HashMap<E, Integer>();
    }

    public void add(E o) {
        if (map.containsKey(o))
            map.put(o, map.get(o) + 1);
        else {
            map.put(o, 1);
            size++;
        }
    }

    public int getCount(E o) {
        if (map.containsKey(o)) return map.get(o);
        return 0;
    }

    public int remove(E o) {
        if (!map.containsKey(o)) return 0;
        int encounters = map.get(o);
        map.remove(o);
        return encounters;
    }

    public int size() {
        return size;
    }

    public void addAll(CountMap<E> src) {
        Map<E, Integer> newMap = src.toMap();
        for (E sourceKey: newMap.keySet()) {
            if (map.containsKey(sourceKey))
                map.put(sourceKey, map.get(sourceKey) + newMap.get(sourceKey));
            else {
                map.put(sourceKey, newMap.get(sourceKey));
                size++;
            }
        }
    }

    public Map<E, Integer> toMap() {
        return map;
    }

    public void toMap(Map<E, Integer> dst) {
        for (E key: map.keySet())
            dst.put(key, map.get(key));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountMapImp<?> that = (CountMapImp<?>) o;

        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode() {
        return map != null ? map.hashCode() : 0;
    }
}
