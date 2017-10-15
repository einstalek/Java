import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class BeanUnitsTest {

    @Test
    public void testPersons() throws InvocationTargetException, IllegalAccessException {
        Person p1 = new Person(20, "Alex");
        Person p2 = new Person(10, "Paul");
        Person p3 = new Person(15, "Ann");
        p1.setSpouse(p3);

        BeanUnits.assign(p2, p1);
        assertEquals(p3, p2.getSpouse());
        assertEquals(p1.getName(), p2.getName());
        assertEquals(p1.getAge(), p2.getAge());
    }
}