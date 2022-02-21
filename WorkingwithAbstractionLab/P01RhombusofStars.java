import java.util.Scanner;

import static java.lang.System.in;

public class P01RhombusofStars {
    public static void main(String[] args) {
        Scanner s = new Scanner(in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int m = 0; m < i; m++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int m = 0; m < n - i; m++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
