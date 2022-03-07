package P06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String driverName = sc.nextLine();

        Ferrari driver = new Ferrari(driverName);

        System.out.println(driver);
    }
}
