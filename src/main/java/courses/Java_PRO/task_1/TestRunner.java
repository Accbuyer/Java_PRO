package courses.Java_PRO.task_1;

import courses.Java_PRO.task_1.annotation.AfterSuite;
import courses.Java_PRO.task_1.annotation.BeforeSuite;
import courses.Java_PRO.task_1.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public static void runTests(Class<?> c) {
        try {
            Method beforeSuite = null;
            Method afterSuite = null;
            List<Method> testMethods = new ArrayList<>();

            for (Method method : c.getDeclaredMethods()) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (beforeSuite == null) {
                        checkStaticMethod(method);
                        beforeSuite = method;
                    } else {
                        throw new RuntimeException("Multiple methods with @BeforeSuite annotation found");
                    }
                }
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (afterSuite == null) {
                        checkStaticMethod(method);
                        afterSuite = method;
                    } else {
                        throw new RuntimeException("Multiple methods with @BeforeSuite annotation found");
                    }
                }
                if (method.isAnnotationPresent(Test.class)) {
                    if (method.getAnnotation(Test.class).priority() <= 10 && method.getAnnotation(Test.class).priority() > 0) {
                        testMethods.add(method);
                    } else {
                        throw new RuntimeException("Priority cannot be greater than 10 or less than 1");
                    }
                }
            }

            testMethods.sort(Comparator.comparingInt(x -> x.getAnnotation(Test.class).priority()));

            if (beforeSuite != null) {
                beforeSuite.invoke(null);
            }

            for (Method testMethod : testMethods) {
                testMethod.invoke(c.getDeclaredConstructor().newInstance(), testMethod.getName());
            }

            if (afterSuite != null) {
                afterSuite.invoke(null);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkStaticMethod(Method method) {
        if (!java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
            throw new RuntimeException("Method " + method.getName() + " must be static");
        }
    }
}
