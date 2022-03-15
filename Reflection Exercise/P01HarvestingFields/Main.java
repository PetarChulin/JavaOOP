package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        while (!input.equals("HARVEST")) {

            getModifier(input, fields);

            input = sc.nextLine();
        }
    }

    private static void getModifier(String input, Field[] fields) {
        switch (input) {
            case "protected":
                Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " "
                                + f.getType().getSimpleName() + " " + f.getName()));
                break;
            case "public":
                Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " "
                                + f.getType().getSimpleName() + " " + f.getName()));
                break;
            case "private":
                Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers()))
                        .forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " "
                                + f.getType().getSimpleName() + " " + f.getName()));
                break;
            default:
                Arrays.stream(fields).forEach(f -> System.out.println(Modifier.toString(f.getModifiers()) + " "
                        + f.getType().getSimpleName() + " " + f.getName()));
                break;
        }
    }
}

