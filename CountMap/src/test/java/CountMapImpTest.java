import org.junit.Test;

import static org.junit.Assert.*;

public class CountMapImpTest {

    @Test
    public void addTest() {
        CountMap<String> countMap = new CountMapImp<String>();
        assertEquals(0, countMap.size());
        countMap.add("Hello");
        countMap.add("asdasd");
        countMap.add("Hello");
        assertEquals(2, countMap.size());
        assertEquals(2, countMap.getCount("Hello"));
        assertEquals(1, countMap.getCount("asdasd"));
        assertEquals(0, countMap.getCount(""));
    }

    @Test
    public void testAddAll() {
        CountMapImp<String> source = new CountMapImp<String>();
        source.add("a");
        source.add("b");
        source.add("c");
        CountMap<String> dest = new CountMapImp<String>();
        dest.addAll(source);
        assertEquals(source, dest);
    }
}