package Shildt;

public class ReverseStr {
    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStrMethod("Hello shild"));

    }

    public String reverseStrMethod(String str) { // Hello
        // rightStr, leftStr нужны для того чтобы разбить строку на две части

        String rightStr;
        String leftStr;
        int length = str.length();


        if (length <= 1) {
            return str;
        }

        leftStr = str.substring(0, length / 2);
        rightStr = str.substring(length / 2, length);

        return reverseStrMethod(rightStr) + reverseStrMethod(leftStr);
    }
}
