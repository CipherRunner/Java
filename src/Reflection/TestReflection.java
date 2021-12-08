package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        // Получение всех методов класса Person
        Class personClass = Person.class;

        Method[] personMethods = personClass.getMethods();

//        for (Method method: personMethods) {
//            System.out.println(method.getName() + " "
//                    + method.getReturnType() + " "
//                    + Arrays.toString(method.getParameterTypes()));
//        }

        Field[] personFields = personClass.getDeclaredFields();

        for (Field field: personFields) {
            System.out.println(field.getName() + " " + field.getType());
        }

        Annotation[] personAnnotations = personClass.getAnnotations();
        for (Annotation annotation: personAnnotations) {
            if (annotation instanceof Autor) {
                System.out.println("Yes");
            }
        }



    }
}
