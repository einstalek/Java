package super_junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void runTests(Class<?> testClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<Method> methods = findTestMethods(testClass);
        int exceptionsCount = 0;

        Object test = testClass.newInstance();

        for (Method testMethod: methods) {
            try {
                testMethod.invoke(test);
            } catch (Exception e) {
                exceptionsCount++;
            }
        }
        System.out.println(exceptionsCount + " exceptions occured.");
    }

    private static List<Method> findTestMethods(Class<?> testClass) {
        List<Method> methods = new ArrayList<>();
        for (Method method: testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(SuperTest.class) && !method.isAnnotationPresent(Ignore.class))
                methods.add(method);
        }
        return methods;
    }
}
