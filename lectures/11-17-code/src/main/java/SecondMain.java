import java.util.ArrayList;
import java.util.List;

public class SecondMain {
    static private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        new Producer().start();
        new Consumer().start();
    }

    private static class Producer extends Thread {
        @Override
        public void run() {
            int x = 0;
            while (true) {
                synchronized (list) {
                    if (list.size() < 100)
                        add(list, ++x);
                    list.notify();
                }
            }
        }

        private void add(List<Integer> list, int x) {
            synchronized (list) {
                list.add(x);
            }
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            int x = 0;
            while (true) {
                synchronized (list) {
                    if (list.isEmpty()) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Integer remove = remove(list);
                System.out.println(remove);
            }
        }

        private Integer remove(List<Integer> list) {
            synchronized (list) {
                return list.remove(0);
            }
        }
    }
}
