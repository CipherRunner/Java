package MultiThread.CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static int result;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Starting");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");

            Random random = new Random();
            int randValue = random.nextInt(10);

            if (randValue < 5)
                throw new Exception("Число меньше пяти");

            return random.nextInt(10);
        });

        executorService.shutdown();

        try {
            int result = future.get();  // get дожидается окончания выполнения потока
            System.out.println("Значения из потока thread получено:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }


    }
}
