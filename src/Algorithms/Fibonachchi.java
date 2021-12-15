package Algorithms;

import java.util.Arrays;

public class Fibonachchi {
    public static void main(String[] args) {
        int n = 100;
        long [] memory = new long[n + 1];
        Arrays.fill(memory, -1);    // заполняем массив, значениями по умолчанию

        System.out.println(fibMemoization(n, memory));
    }




    // рекурсивный с сохранением результатов
    private static long fibMemoization(int n, long[] mem) {
        if (mem[n] != -1)       // Если в ячейке массива значение не по умолчанию
            return mem[n];

        if (n <= 1)
            return n;
        long result = fibMemoization(n-1, mem) + fibMemoization(n-2, mem);
        mem[n] = result;
        return result;

    }


    // медленный, рекурсивный
    private static long fibSlow(int n) {
        if (n <= 1)
            return n;
        return fibSlow(n-1) + fibSlow(n-2);
    }


    // эффективный способ, линейный
    private static long fibFast(int n) {
        long [] arr = new long[n+1];        // O(n)
        arr[0] = 0;                           // O(1)
        arr[1] = 1;                       // O(1)
        for (int i = 2; i <= n; i++) {      // O(n)
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    // без использования массива
    private static long fibRes(int n) {
        long n1 = 1;
        long n2 = 0;

        long r = 0;

        for (int i = 2; i <= n; i++){
            r = n1 + n2;
            n2 = n1;
            n1 = r;
        }
        return r;
    }

}
