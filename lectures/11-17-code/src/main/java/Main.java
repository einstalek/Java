public class Main {
    volatile private boolean keepRunnig = true;

    public static void main(String[] args) throws InterruptedException {
        final Main main = new Main();

        new Thread( () -> {
            main.run();
        }).start();

        Thread.sleep(10);
        main.stop();
    }

    private void stop() {
        keepRunnig = false;
    }

    private void run() {
        int x = 0;
        while (keepRunnig) {
            ++x;
        }
        System.out.println(x);
    }
}
