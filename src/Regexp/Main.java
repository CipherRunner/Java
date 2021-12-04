package Regexp;

public class Main {
    public static void main(String[] args) {
        /*
            \\d - одна цифра
            \\w - одна буква

            +   - один или более
            *   - ноль или более
            ?   - символ который идет до него может быть а может не быть

            (x|y|z) - для перечислений, в скобках описываем какие то вероятные вещи
            [- +] - тоже самое
            [abc] - тоже самое

            [a-zA-Z] - можем описывать какие то большие множества не перечисляя эти множества в данном случае алфавит

            [0-9] - одна цифра
            \\d   - одна цифра

            [^abc] - все символы кроме [abc]
            .      - любой символ

            {2}   - точное количество предыдущих символов
            {3, } - три и более символов
            {2, 4} - от двух до четырех символов

         */

        String str = "-12321321321";
        String str2 = "12312312312";
        String str3 = "+1231231212";
        System.out.println(str.matches("([-+])?\\d*"));

        String str4 = "afdsfsd12312";
        System.out.println(str4.matches("[a-zA-Z]+?\\d*"));

        String str5 = "hello";
        String str6 = "ABC";
        System.out.println(str6.matches("[^A]"));

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.com";
        String url3 = "telegram";
        System.out.println(url.matches("http://www\\..+[com ru]"));
        System.out.println(url2.matches("http://www\\..+[com ru]"));
        System.out.println(url3.matches("http://www\\..+[com ru]"));


        String str7 = "12";
        System.out.println(str7.matches("\\d{3}"));



    }
}
