package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Constructor<BlackBoxInt> access = BlackBoxInt.class.getDeclaredConstructor();
        access.setAccessible(true);
        BlackBoxInt blackBoxInt = access.newInstance();

        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);

        while (!input.equals("END")) {

            String method = input.split("_")[0];
            int number = Integer.parseInt(input.split("_")[1]);

            Method methodType = BlackBoxInt.class.getDeclaredMethod(method , int.class);
            methodType.setAccessible(true);
            methodType.invoke(blackBoxInt , number);

            input = sc.nextLine();
            System.out.println(field.get(blackBoxInt));
        }
    }
}
