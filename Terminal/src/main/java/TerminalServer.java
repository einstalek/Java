public interface TerminalServer {
    public int getBalance(Client client) throws NoConnectionException;
    public boolean changeBalance(Client client) throws NoConnectionException, WrongOperationException, NotEnoughCashException;
}
