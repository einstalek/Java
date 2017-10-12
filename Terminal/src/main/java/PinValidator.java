import javax.security.auth.login.AccountLockedException;

public interface PinValidator {
    public boolean authorize(Client client) throws NoConnectionException, AccountIsLockedException;
    public void lock(Client client);
    public String timeOfLocking(Client client);
}
