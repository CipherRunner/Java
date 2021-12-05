package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. n commodo ligula eget dolor. " +
                "Aenean massa. timcook@apple.com Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
                "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. " +
                "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. " +
                "Nullam dictum paveldurov@gmail.com felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. " +
                "Vivamus elementum semper nisi.";

        Pattern email = Pattern.compile("(\\w+)@(apple|gmail)\\.(ru|com)");
        Matcher matcher = email.matcher(str);

        while (matcher.find()) {    // Пока возвращается тру из метода find
            System.out.println(matcher.group(1));
        }
    }
}
