import super_junit.TestRunner;
import tests.ArrayListTest;
import xml.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    private String hello;

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        TestRunner.runTests(ArrayListTest.class);
    }
}
