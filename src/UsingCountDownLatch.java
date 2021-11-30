import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch это такой класс при создании объекта которого мы должны в конструктор
        // передать число, и это число означает сколько раз мы должны вызвать метод countDown()
        // (из любого количества потоков). Чтобы await больше не ждал.
        // Пока у нас есть какое-то число не равное нулю у нас await ждет

        CountDownLatch countDownLatch = new CountDownLatch(3);                      // "защелка"

        ExecutorService executorService = Executors.newFixedThreadPool(3);  // 3 потока

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(countDownLatch));                  // каждому потоку назначается задание
        }
        executorService.shutdown();

        countDownLatch.await();                                                     // ждать
        System.out.println("Защелка открылась, исполняется main thread");           // после выполнения задания потоками
    }
}

class Processor implements Runnable {                                               // задание
    private CountDownLatch countDownLatch;                                          // внутренний CountDownLatch

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();                                                 // countDown декрементирует переменную
    }

}
