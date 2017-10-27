import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <E> E max(List<E> list, Comparator<E> comparator) {
        E max = list.get(0);

        for (E x : list)
            if (comparator.compare(x, max) > 0) {
                max = x;
            }
        return max;
    }

    public static <E> E nonNull(E o) {
        if (o == null) throw new NullPointerException();
        return o;
    }

    public static <E> List<E> join(List<? extends E> list1, List<? extends E> list2) {
        List<E> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static<E> void addAll(List<? extends E> src, List<? super E> dst) {
        dst.addAll(src);
    }
}
