import java.lang.reflect.Proxy;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calculator calculator1 = new SimpleCalculator();
        Calculator calculator2 = new LogingCalculatorDecorator(calculator1);

        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class},
                new LogingDynamicProxy(new SimpleCalculator())
        );
        proxy.doCalculation(10);

        Calculator c = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Calculator.class},
                new HashingProxy(new SimpleCalculator())
        );
        c.doCalculation(10);
    }
}
