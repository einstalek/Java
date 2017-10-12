public class WrongOperationException extends Exception{
    /*
    Это исключение срабатывает, когда проводится операции с суммой, не кратной 100.
     */

    @Override
    public String toString() {
        return "Сумма должна делиться на 100";
    }
}
