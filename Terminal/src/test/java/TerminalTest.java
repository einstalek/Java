import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class TerminalTest {

    @Test
    public void testSuccessAuthorization() throws AccountIsLockedException, NoConnectionException {
        Client client = new Client(33);
        client.pin = "qwerty";
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(validator.authorize(client)).thenReturn(client.pin.equals("qwerty"));

        Terminal t = new Terminal(server, validator);
        assertEquals(AuthorizationStatus.SUCCESS, t.authorizationTrial(client));
    }

    @Test
    public void testFailedAuthorization() throws AccountIsLockedException, NoConnectionException {
        Client client = new Client(33);
        client.pin = "abcde";
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(validator.authorize(client)).thenReturn(client.pin.equals("qwerty"));

        Terminal t = new Terminal(server, validator);
        assertEquals(AuthorizationStatus.FAILED, t.authorizationTrial(client));
    }

    @Test
    public void testConnectToLockedAccount() throws AccountIsLockedException, NoConnectionException {
        Client client = new Client(33);
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(validator.authorize(client)).thenThrow(new AccountIsLockedException());
        Mockito.when(validator.timeOfLocking(client)).thenReturn("10-12-2017 20:12:37");

        Terminal t = new Terminal(server, validator);
        assertEquals(AuthorizationStatus.LOCKED, t.authorizationTrial(client));
    }

    @Test
    public void testAuthorizeWithoutConnection() throws AccountIsLockedException, NoConnectionException {
        Client client = new Client(33);
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(validator.authorize(client)).thenThrow(new NoConnectionException());

        Terminal t = new Terminal(server, validator);
        assertEquals(AuthorizationStatus.NO_CONNECTION, t.authorizationTrial(client));
    }

    @Test
    public void testGetCashFromEmptyBalance() throws WrongOperationException, NotEnoughCashException, NoConnectionException {
        Client client = new Client(33);
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(server.changeBalance(client)).thenThrow(new NotEnoughCashException());

        Terminal t = new Terminal(server, validator);
        assertFalse(t.changeBalance(client));
    }

    @Test
    public void testWrongCashQuantityOperation() throws WrongOperationException, NotEnoughCashException, NoConnectionException {
        Client client = new Client(33);
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(server.changeBalance(client)).thenThrow(new WrongOperationException());

        Terminal t = new Terminal(server, validator);
        assertFalse(t.changeBalance(client));
    }

    @Test
    public void testNormalChangeBalance() throws WrongOperationException, NotEnoughCashException, NoConnectionException {
        Client client = new Client(33);
        TerminalServer server = Mockito.mock(TerminalServer.class);
        PinValidator validator = Mockito.mock(PinValidator.class);
        Mockito.when(server.changeBalance(client)).thenReturn(true);

        Terminal t = new Terminal(server, validator);
        assertTrue(t.changeBalance(client));
    }

}