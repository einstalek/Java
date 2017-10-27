import java.util.Map;

public interface CountMap<E> {

    void add(E o);

    int getCount(E o);

    int remove(E o);

    int size();

    void addAll(CountMap<E> src);

    Map<E, Integer> toMap();

    void toMap(Map<E, Integer> dst);
}
