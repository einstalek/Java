import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testMerry() {
        Person m = new Person(true, "m");
        Person w = new Person(false, "w");

        assertTrue(m.marry(w));
        assertEquals(w, m.getSpouse());
        assertEquals(m, w.getSpouse());
    }

    @Test
    public void testMerryWithDivorce() {
        Person m1 = new Person(true, "m");
        Person w1 = new Person(false, "w");
        m1.marry(w1);

        Person m2 = new Person(true, "m2");
        Person w2 = new Person(false, "w2");
        w2.marry(m2);

        assertTrue(w1.marry(m2));

        assertNull(m1.getSpouse());
        assertNull(w2.getSpouse());
        assertEquals(m2, w1.getSpouse());
        assertEquals(w1, m2.getSpouse());

        assertFalse(w1.marry(m2));
    }

    @Test
    public void testMarryPersonsWithSameGender() {
        testMarryPersonsWithSameGender(true);
        testMarryPersonsWithSameGender(false);
    }

    @Test
    public void testDivorce() {
        Person m = new Person(true, "m");
        assertFalse(m.divorce());

        Person w = new Person(false, "w");
        m.marry(w);

        assertTrue(m.divorce());

        assertNull(m.getSpouse());
        assertNull(w.getSpouse());
    }

    private void testMarryPersonsWithSameGender(boolean gender) {
        Person p1 = new Person(gender, "A");
        Person p2 = new Person(gender, "B");

        assertFalse(p1.marry(p2));
        assertFalse(p2.marry(p1));
    }
}