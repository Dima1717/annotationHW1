package annottation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Sample sample = new Sample();

        Class<?> cls = Sample.class;

        Method [] methods = cls.getDeclaredMethods();

        for (Method m : methods)
            if (m.isAnnotationPresent(Test.class)) {
                Test test = m.getAnnotation(Test.class);
                int s = (Integer) m.invoke(null, test.a(), test.b());

                System.out.println(s);
            }
    }
}
