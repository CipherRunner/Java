import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }

    public static void produce() throws InterruptedException {      // Один или много потоков которые создают запросы или что-то еще
        Random random = new Random();
        while (true) {
            bq.put(random.nextInt(100));           // Этот метод ждет, если наш consumer еще не взял элементы из
                                                         // очереди.
        }


    }

    public static void consumer() throws InterruptedException {     // Это то что берет из этого общего пула сущностей, берет сущность и как-то ее обрабатывает
        Random random = new Random();

        while (true) {
            Thread.sleep(100);

            bq.take();                      // Этот метод отличается от метода poll
                                           // тем, что если элементов нет он ждет
            if (random.nextInt(10) == 5)
            System.out.println(bq.take()); // вывод полученного элемента на экран
            System.out.println("Queue size: " +bq.size());
        }

    }
}
