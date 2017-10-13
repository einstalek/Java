package tests;

import super_junit.Ignore;
import super_junit.SuperTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @SuperTest
    private void testSize() {
        System.out.println("Size test");
        List<Object> objects = new ArrayList<>();
        objects.add("1");

        if (objects.size() != 1)
            throw new IllegalStateException();
    }

    @SuperTest
    @Ignore
    public void testAdd() {
        System.out.println("Add test");
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
    }

    @SuperTest
    public void rmvTest() {
        System.out.println("Remove test");
        List<Integer> list = new ArrayList<>();
        list.remove(1);
    }
}
