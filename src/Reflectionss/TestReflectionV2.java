package Reflectionss;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflectionV2 {
    public int iye;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        // Название_класса_1 Название_класса_2 название_метода
        // это будет одна строка, а три метода next() будут делить строку

        // Чтобы использовать рефлексию мы должны сначала получить доступ к объекту
        // класса Class
        // test java.lang.Thread java.lang.String setName

        Class classObj1 = Class.forName(scanner.next());
        Class classObj2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        Method method = classObj1.getMethod(methodName, classObj2);

        // создаем объекты вызываем метод
        Object o1 = classObj1.newInstance();
        Object o2 = classObj2.getConstructor(String.class).newInstance("String value");

        method.invoke(o1, o2);

        System.out.println(o1);
    }

}
