import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUnits {

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        List<Method> from_getters = allGetters(from);
        List<Method> to_setters = allSetters(to);

        for (Method getter: from_getters) {
            for (Method setter: to_setters) {
                if ( (getter.getReturnType() == setter.getParameterTypes()[0] || getter.getReturnType() == setter.getParameterTypes()[0].getSuperclass())  &&
                        getter.getName().substring(3).equals(setter.getName().substring(3))) {
                    try {
                        setter.invoke(to, getter.invoke(from));
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }
    }

    public static List<Method> allSetters(Object o) {
        List<Method> setters = new ArrayList<>();
        for (Method method: o.getClass().getMethods()) {
            if (!method.getName().startsWith("set")) continue;
            if (method.getParameterCount() != 1) continue;
            setters.add(method);
        }
        return setters;
    }

    public static List<Method> allGetters(Object o) {
        List<Method> getters = new ArrayList<>();
        for (Method method: o.getClass().getMethods()) {
            if (!method.getName().startsWith("get")) continue;
            if (method.getParameterCount() != 0) continue;
            if (void.class.equals(method.getReturnType())) continue;
            getters.add(method);
        }
        return getters;
    }
}
