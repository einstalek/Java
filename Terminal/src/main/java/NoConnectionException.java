public class NoConnectionException extends Exception {
    /*
    Это исключение срабатывает, когда нет подключения к серверу.
     */

    @Override
    public String toString() {
        return "Нет соединения.";
    }
}
