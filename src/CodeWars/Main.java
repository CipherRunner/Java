package CodeWars;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println(greet("george"));

    }
    public static String greet(String name){
        char [] ch = name.toCharArray();
        String str1 = "";

        String str = "";
        String str2 = "!";
        for (int i = 0; i < ch.length; i++) {
            if (i == 0) {
                str1 += String.valueOf(ch[i]).toUpperCase();
            }
            if (i > 0) {
                str1 += String.valueOf(ch[i]).toLowerCase();
            }
        }


        return "Hello " + str1 + "!";
    }

}
