package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
