package Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

// На входе массив из чисел до 10, нужно реализовать алгоритм который составляет максимальное число из чисел массива

public class Greedy {
    public static int[] randomArr(int sizeValue) {
        Random random = new Random();
        int[] arr = new int[sizeValue];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
    
    public static long optimalBiggestValue(int[] arr) {
        int[] arr2 = arr;
        Arrays.sort(arr2); // O(n * log(n))

        StringBuilder str = new StringBuilder();

        for (int i = arr2.length-1; i >= 0; i--)
        {
            str.append(arr2[i]);
        }

        //return Long.parseLong(String.join("", Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).map(String::valueOf).toArray(String[]::new)));

        return Long.parseLong(str.toString());
    }

    public static void main(String[] args) {
        int [] arr = randomArr(10);
        System.out.println(Arrays.toString(arr));
        System.out.println(optimalBiggestValue(arr));
    }
}
