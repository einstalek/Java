import java.util.Scanner;

enum AuthorizationStatus {SUCCESS, FAILED, NO_CONNECTION, LOCKED}

public class Terminal {
    private final TerminalServer server;
    private final PinValidator validator;

    public Terminal(TerminalServer server, PinValidator validator) {
        this.server = server;
        this.validator = validator;
    }

    public AuthorizationStatus authorizationTrial(Client client) {
        boolean status = false;
        try {
            status = validator.authorize(client);
        } catch (NoConnectionException e) {
            System.out.println(e);
            return AuthorizationStatus.NO_CONNECTION;
        } catch (AccountIsLockedException e) {
            System.out.println(e + validator.timeOfLocking(client));
            return AuthorizationStatus.LOCKED;
        }
        if (status) return AuthorizationStatus.SUCCESS;
        else return AuthorizationStatus.FAILED;
    }

    public void authorize(Client client) {
        boolean finished = false;
        int trials_count = 0;
        AuthorizationStatus status = AuthorizationStatus.FAILED;

        while (trials_count < 3 & !finished) {
            status = authorizationTrial(client);
            switch (status) {
                case SUCCESS:
                    finished = true;
                    operationHandler(client);
                    break;
                case LOCKED:
                    break;
                case NO_CONNECTION:
                    break;
                case FAILED:
                    break;
            }
            trials_count++;
        }

        if (status == AuthorizationStatus.FAILED) {
            System.out.println("Аккаунт будет заблокирован.");
            validator.lock(client);
        }
    }

    public void operationHandler(Client client) {
        Scanner sc = new Scanner(System.in);
        client.operationID = sc.nextInt();

        switch (client.operationID) {
            case 1:
                getBalance(client);
                break;
            case 2:
                client.deltaCash = sc.nextInt();
                changeBalance(client);
                break;
            default:
                break;
        }
    }

    public void getBalance(Client client) {
        try {
            System.out.println("Текущий баланс: " + server.getBalance(client));
        } catch (NoConnectionException e) {
            System.out.println(e);
        }
    }

    public boolean changeBalance(Client client) {
        boolean status = false;
        try {
            server.changeBalance(client);
            status = true;
        } catch (NoConnectionException e) {
            System.out.println(e);
            return false;
        } catch (WrongOperationException e) {
            System.out.println(e);
            return false;
        } catch (NotEnoughCashException e) {
            System.out.println(e);
            return false;
        }
        return status;
    }
}
