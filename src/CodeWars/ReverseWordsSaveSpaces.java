package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsSaveSpaces {
    public static void main(String[] args) {
        int [] arr2 = {5, 4, 3, 2, 1 };
        System.out.println(Kata2.isSortedAndHow(arr2));

    }
}


/* Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.
        Examples
        "This is an example!" ==> "sihT si na !elpmaxe"
        "double  spaces"      ==> "elbuod  secaps"
*/
class Kata {
    public static String reverseWords(final String original) {
        StringBuilder sb = new StringBuilder(original);


        List<String> listString = new ArrayList<>();

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '\u0020') {
                listString.add(word.reverse().toString());
                word = new StringBuilder(" ");
                listString.add(word.toString());
                word = new StringBuilder();
            } else {
                word.append(sb.charAt(i));
                if (i == sb.length()-1) {
                    listString.add(word.reverse().toString());
                }
            }
        }

        StringBuilder outLine = new StringBuilder();

        for (String words: listString) {
            outLine.append(words);
        }

        return outLine.toString();
    }
}

class Kata2 {
    public static String isSortedAndHow(int[] array) {
        String yeaUp = "yes, ascending";
        String yeaDown = "yes, descending";
        String no = "no";

        int [] arr = array;
        int [] arrUp = array.clone();
        int [] arrDown = new int[array.length];

        for (int n = 0; n < arrUp.length; n++) {
            for (int i = 0; i <arrUp.length-1; i++) {
                if (arrUp[i] > arrUp[i+1]) {
                    int temp = 0;
                    temp = arrUp[i];
                    arrUp[i] = arrUp[i+1];
                    arrUp[i+1] = temp;
                }
            }
        }
        int counter = 0;

        for (int m = arrUp.length-1; m >= 0; m--) {
            arrDown[counter] = arrUp[m];
            counter++;
        }

        if (Arrays.equals(array, arrUp)) {
            return yeaUp;
        } else if (Arrays.equals(array, arrDown)) {
            return yeaDown;
        } else return no;
    }
}


