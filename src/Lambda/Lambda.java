package Lambda;


import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Asdasasd");
        list.add("Adsa");
        list.add("Asdasasddsfsdf");
        list.add("A");
        list.add("dsfdfds");
        list.add("Adsfsdfdsfsdddsdfa");

        list.sort((o1, o2) -> {
            return Integer.compare(o1.length(), o2.length());
        });

        System.out.println(list.toString());

    }
}


