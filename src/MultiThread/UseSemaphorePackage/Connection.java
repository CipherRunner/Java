package MultiThread.UseSemaphorePackage;

import java.util.concurrent.Semaphore;

// Singleton
public class Connection { // Класс будет представлять соединение к серверу, это наш ценный ресурс и мы хотим разделить его между потоками
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);


    private Connection() {      // Такой конструктор дает понять пользователям, что мы не можем создавать сколько угодно классов Connection

    }

    public static Connection getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();               // Здесь может возникнуть исключение и тогда до следующей строки исполнение не дойдет
        } finally {
            semaphore.release();
        }
    }

    private void doWork() {      // В этом методе мы будем делать какую то полезную работу с нашим соединением
        synchronized (this) {
            connectionsCount++;
            System.out.println("Connection count: " + connectionsCount);
        }

        try {                           // какая то полезная работа
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connectionsCount--;
        }

    }


}
