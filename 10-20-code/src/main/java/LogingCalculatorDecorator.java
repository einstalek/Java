public class LogingCalculatorDecorator implements Calculator{
    private final Calculator calculator;

    public LogingCalculatorDecorator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double doCalculation(double input) {
        System.out.println("Input >> " + input);
        double v =  calculator.doCalculation(input);
        System.out.println("Output >> " + v);
        return v;
    }
}
