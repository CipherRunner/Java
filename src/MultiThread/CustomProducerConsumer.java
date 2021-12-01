package MultiThread;

import java.util.LinkedList;
import java.util.Queue;

public class CustomProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        ProdConsumer prodConsumer = new ProdConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prodConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prodConsumer.consume();
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
}

class ProdConsumer {
    Queue<Integer> queue = new LinkedList();          // заводим обычную очередь
    private final int LIMIT = 10;                     // максимальное значение сущостей в очереди
    private final Object lock = new Object();               // создаем объект на котором будет происходить синхронизация

    // В этом методе мы будем добавлять новые числа в очередь. Реализовать нужно так, чтобы два потока работали совместно.
    // Если очередь итак полна, то добавлять новые элементы нельзя.

    public void produce() throws InterruptedException {
        int value = 0;

        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) {
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    // Если очередь пустая нужно чтобы поток ждал и не извлекал из очереди пустые элементы.

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }

                int inputValue = queue.poll();
                System.out.println(inputValue);
                System.out.println("Queue size: " + queue.size());
                lock.notify();
            }
            Thread.sleep(500);
        }



    }

}