import java.util.Scanner;

// Методы wait и notify
public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
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

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread стартанул");
            wait();     // 1. Отдает монитор. 2. Ждет пока не будет вызван notify/notifyAll, и пока не будет отдан монитор обратно
                        // В данном случае вызывается на объекте this (this.wait()). Но если синхронизованный блок привязан не к this, а к какому-то другому
                        // объекту данная консструкция не сработает и нужно будет вызывать метод на другом объекте.
                        // с notify() так же.
            System.out.println("Producer thread продолжил работу..");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);                           // Здесь мы это делаем для того чтобы поток producer точно был первым
                                                            // точно запустился первым и дошел до вызова метода wait.
        Scanner scanner = new Scanner(System.in);           // для того чтобы программа продолжилась после нажатия enter
        synchronized (this) {
            System.out.println("Нажмите Enter чтобы вернутся в поток 1");
            scanner.nextLine();                             // здесь scanner считает строку, и продолжит свое выполнение
            notify();                                       // Чтобы на объекте this все потоки которые ждут (которые вызвали метод wait)
                                                            // проснулись и продолжили свое выполнение. !!Notify не возвращает монитор
                                                            // то есть если дальше в этом блоке будет какой-нибудь долгий цикл, поток 1 исполнится
                                                            // только тогда, когда этот цикл завершит работу.

        }



    }

}