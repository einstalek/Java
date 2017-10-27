public class HardCalculator implements Calculator {
    @Cache(saveTo = CacheStrategy.MEMORY, time = 10)
    public double doCalculation(double input) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return 0;
    }
}
