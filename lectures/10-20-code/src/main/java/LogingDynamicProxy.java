import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogingDynamicProxy implements InvocationHandler {
    private final Object delegate;

    public LogingDynamicProxy(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Input parameters: ");
        for (Object arg: args)
            System.out.println(arg + ", ");
        System.out.println();
        Object result =  method.invoke(delegate, args);
        System.out.println("Result = " + result);
        return result;
    }
}
