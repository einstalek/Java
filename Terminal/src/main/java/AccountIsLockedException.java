public class AccountIsLockedException extends Exception {
    @Override
    public String toString() {
        return "Аккаунт заблокирован до ";
    }
}
