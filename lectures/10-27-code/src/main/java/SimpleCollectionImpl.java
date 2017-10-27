import java.util.ArrayList;
import java.util.List;

public class SimpleCollectionImpl<E> implements SimpleCollection<E> {

    private final List<E> list = new ArrayList<E>();

    public void add(E o) {
        this.list.add(o);
    }

    public E getLast() {
        return list.get(list.size() - 1);
    }
}
