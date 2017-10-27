import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class HashingProxy implements InvocationHandler{
    private final Object delegate;
    private Map<List<Object>, Object> resultsMap;

    public HashingProxy(Object delegate) {
        this.delegate = delegate;
        resultsMap = new HashMap<List<Object>, Object>();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> key = getKey(method, args);

        Object result = method.invoke(delegate, args);

        // Проверяем, что аннотация есть именно в реализации делегата
        Method delegateMethod = delegate.getClass().getMethod(method.getName(), method.getParameterTypes());
        boolean annotationPresent = delegateMethod.isAnnotationPresent(Cache.class);
        if (annotationPresent) {
            Cache annotation = delegateMethod.getAnnotation(Cache.class);
            if (annotation.saveTo() == CacheStrategy.MEMORY) resultsMap.put(key, result);
            else throw new IOException();
        }
        return result;
    }

    public List<Object> getKey(Method method, Object[] args) {
        List<Object> key = new ArrayList<Object>();
        key.add(method);
        key.addAll(Arrays.asList(args));
        return key;
    }
}
