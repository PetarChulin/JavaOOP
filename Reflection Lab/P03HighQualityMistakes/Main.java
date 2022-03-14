import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)  {

        Class<Reflection> reflection = Reflection.class;
        Field[] fields = reflection.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(f -> System.out
                        .printf("%s must be private!%n", f.getName()));

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get")
                        && !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName)).forEach(get -> System.out.printf(
                        "%s have to be public!\n", get.getName()));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("set")
                        && !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName)).forEach(get -> System.out.printf(
                        "%s have to be private!\n", get.getName()));
    }
}






