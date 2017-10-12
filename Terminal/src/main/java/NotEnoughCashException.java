public class NotEnoughCashException extends Exception {
    @Override
    public String toString() {
        return "Недостаточно денег на счету.";
    }
}
