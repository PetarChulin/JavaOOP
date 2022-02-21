package WorkingwithAbstractionLab;

import java.util.Scanner;

public class P01RhombusofStars {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        StringBuilder rhombus = new StringBuilder();
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                rhombus.append(" ");
            }
            for (int m = 0; m < i; m++) {
                rhombus.append("* ");
            }
            rhombus.append("\n");
        }
        for (int i = 0; i < n; i++) {
            rhombus.append("* ");
        }
        rhombus.append("\n");

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                rhombus.append(" ");
            }
            for (int m = 0; m < n - i; m++) {
                rhombus.append("* ");
            }
            rhombus.append("\n");
        }
        System.out.println(rhombus);
    }
}

