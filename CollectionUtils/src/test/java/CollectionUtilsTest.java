import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionUtilsTest {
    @Test
    public void testAddAll() {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Number> l2 = new ArrayList<>();
        l1.add(1); l1.add(2);
        l2.add(3.2); l2.add(5.2);
        CollectionUtils.addAll(l1, l2);
        assertEquals(4, l2.size());
    }

    @Test
    public void testNewArrayList() {
        List<Integer> l = CollectionUtils.newArrayList();
        l.add(2);
        assertEquals(1, l.size());
        assertEquals(new Integer(2), l.get(0));
    }

    @Test
    public void testIndexOf() {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            l.add(i);
        assertEquals(1, CollectionUtils.indexOf(l, 1));
    }

    @Test
    public void testLimit() {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            l.add(i);
        assertEquals(l, CollectionUtils.limit(l, l.size()));
    }

    @Test
    public void testAdd() {
        List<Number> l = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            CollectionUtils.add(l, i);
        assertEquals(3, l.size());
    }

    @Test
    public void testRemove() {
        List<Number> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            CollectionUtils.add(l, i);
        CollectionUtils.add(l, 1.1);

        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            CollectionUtils.add(l2, i);

        CollectionUtils.removeAll(l, l2);
        assertEquals(3, l.size());
    }

    @Test
    public void testContainsAll() {
        List<Number> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            CollectionUtils.add(l, i);
        CollectionUtils.add(l, 1.1);

        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            CollectionUtils.add(l2, i);

        assertTrue(CollectionUtils.containsAll(l, l2));
    }

    @Test
    public void testContainsAny() {
        List<Number> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            CollectionUtils.add(l, i);
        CollectionUtils.add(l, 1.1);

        List<Integer> l2 = new ArrayList<>();
        for (int i = 4; i < 8; i++)
            CollectionUtils.add(l2, i);

        assertTrue(CollectionUtils.containsAny(l, l2));
    }

    @Test
    public void testRange() {
        List<Double> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            CollectionUtils.add(l, new Double(i));
        CollectionUtils.add(l, 1.1);
        CollectionUtils.add(l, 2.1);
        assertEquals(3, CollectionUtils.range(l, 1., 3.).size());
    }

    @Test
    public void testRangeComparator() {
        List<Double> l = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            CollectionUtils.add(l, new Double(i));
        CollectionUtils.add(l, 1.1);
        CollectionUtils.add(l, 2.1);
        assertEquals(3, CollectionUtils.range(l, 1., 3., new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 - o2 >= 0) return 1;
                else return -1;
            }
        }).size());
    }
}