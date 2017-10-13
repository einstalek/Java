import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionUtils {
    public static List<Method> allMethods(Class<?> clazz) {
        Class<?> current_clazz = clazz;
        ArrayList<Method> result = new ArrayList<Method>();

        while (current_clazz != null) {
            Collections.addAll(result, current_clazz.getDeclaredMethods());
            current_clazz = current_clazz.getSuperclass();
        }
        return result;
    }
}
