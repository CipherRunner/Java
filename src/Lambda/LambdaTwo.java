package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTwo {
    public static void main(String[] args) {
        int[] num = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(num);
        fillList(list);

//        for (int i = 0; i < 10; i++) {
//            num[i] = num[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }

        num = Arrays.stream(num).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(Arrays.toString(num));
        System.out.println(list);



        int[] num2 = new int[10];
        num2 = Arrays.stream(num2).map(a -> 3).toArray();
        num2 = Arrays.stream(num2).map(a -> a + 1).toArray();
        fillArr(num2);


        List<Integer> list2 = new ArrayList<>();
        fillList(list2);

        System.out.println(Arrays.toString(num2));
        System.out.println(list2);

        // filter

        num2 = Arrays.stream(num2).filter(a -> a % 2 == 0).toArray();          // Тело лямбды должно возвращать либо тру либо фолс
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(num2));
        System.out.println(list2);

        // foreach method
        Arrays.stream(num2).forEach(a -> System.out.print(a + " "));
        list2.forEach(a -> System.out.print(a + " "));


        // reduce method
        int[] num3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(num3);
        fillList(list3);

        int sum = Arrays.stream(num3).reduce((acc, b) -> acc + b).getAsInt();
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println("\n" + sum);
        System.out.println(sum2);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(12);
        set = set.stream().map(a -> a * 2).collect(Collectors.toSet());

        System.out.println(set);



    }
    public static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
           arr[i] = i+1;
        }
    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
    }
}
