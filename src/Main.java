/* Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

        Examples
        "This is an example!" ==> "sihT si na !elpmaxe"
        "double  spaces"      ==> "elbuod  secaps"

*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(Kata.reverseWords("This is an  example!"));
    }
}

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

