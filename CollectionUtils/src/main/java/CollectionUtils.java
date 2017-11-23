import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> dest) {
        for (T e: source)
            dest.add(e);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        for (int i = 0; i < source.size(); i++)
            if (o.equals(source.get(i)))
                return i;
        return -1;
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(source.get(i));
        return list;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T e: c2)
            if (removeFrom.contains(e))
                removeFrom.remove(e);
    }

    public static <T> boolean containsAll(List<? super T> c1, List <? extends T> c2) {
        boolean contains = true;
        for (T e: c2)
            if (!c1.contains(e))
                contains = false;
        return contains;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        boolean contains = false;
        for (T e: c2)
            if (c1.contains(e))
                contains = true;
        return contains;
    }

    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        ArrayList<T> arrayList = new ArrayList<>();
        CollectionUtils.addAll(list, arrayList);
        for (T e: list)
            if ((e.compareTo(min) <= 0) || (e.compareTo(max)) >= 0)
                arrayList.remove(e);
        return arrayList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        ArrayList<T> ls = new ArrayList<>();
        CollectionUtils.addAll(list, ls);
        for (T e: ls)
            if ((comparator.compare(e, min) < 0) || (comparator.compare(e, min) > 0))
                ls.remove(e);
        return ls;
    }
}
