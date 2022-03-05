package Problem5Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> numbers = Arrays.stream(s.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(s.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone phone = new Smartphone(numbers, urls);
        try {
            System.out.print(phone.call());
            System.out.print(phone.browse());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}

