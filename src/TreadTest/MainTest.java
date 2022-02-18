package TreadTest;

import java.util.Random;

public class MainTest {

    public static class Shared {
        public int cash;

        public Shared(int cash) {
            this.cash = cash;
        }

        public synchronized void withdraw(int amount) {
            if (this.cash >= amount) {
                try {
                    Thread.sleep(500);
                    this.cash -= amount;
                    System.out.printf("[%s] - %d 출금, 잔액 %d \n",
                            Thread.currentThread().getName(),amount,this.cash);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Task implements Runnable {
        private Shared shared;

        public Task(Shared shared) {
            this.shared = shared;
        }

        @Override
        public void run() {
            while (shared.cash >= 0) {
                int amount = (new Random().nextInt(3) + 1) * 100;
                shared.withdraw(amount);
            }
        }
    }


    public static void main(String[] args) {
//        ImplementsRunnable runnable = new ImplementsRunnable();
//        Thread thread1 = new Thread(runnable, "implement");
//        thread1.start();
//
//        ExtendThread thread2 = new ExtendThread("extend");
//        thread2.start();

        Shared shared = new Shared(1000);

        Thread thread1 = new Thread(new Task(shared));
        Thread thread2 = new Thread(new Task(shared));
        thread1.start();
        thread2.start();

    }
}
