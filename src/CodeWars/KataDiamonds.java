package CodeWars;/*
Description:
Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.

Task
You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.

Examples
A size 3 diamond:

 *
***
 *
...which would appear as a string of " *\n***\n *\n"

A size 5 diamond:

  *
 ***
*****
 ***
  *
...that is:

"  *\n ***\n*****\n ***\n  *\n" */

public class KataDiamonds {
    public static void main(String[] args) {
        System.out.println(print(21));
    }
    public static String print(int n) {
        if (n%2==0 || n < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");

        int allValueDiamond = n;

        int i2 = (allValueDiamond-1)/2;

        for (int i = 1; i <= allValueDiamond; i+=2) {
            //System.out.printf("%s" + "%s" + "\n", spacer(i2), diamonder(i));
            sb.append(spacer(i2)).append(diamonder(i)).append("\n");
            i2--;
        }

        i2 = 1;
        for (int i = allValueDiamond-2; i >= 1; i-=2) {
            //System.out.printf("%s" + "%s" + "\n", spacer(i2), diamonder(i));
            sb.append(spacer(i2)).append(diamonder(i)).append("\n");
            i2++;
        }

        return sb.toString();

    }
    public static String spacer(int n) {
        String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space);
        }
        return sb.toString();
    }
    public static String diamonder(int n) {
        String diamond = "*";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(diamond);
        }
        return sb.toString();
    }


}
