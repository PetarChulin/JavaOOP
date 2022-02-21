package WorkingwithAbstractionLab;

import java.util.Scanner;

public class P01RhombusofStarsMethods {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        StringBuilder rhombus = new StringBuilder();
        int n = Integer.parseInt(s.nextLine());

        for (int i = 0; i < n; i++) {
            addSymbol(rhombus, n - i, " ");
            addSymbol(rhombus, i, "* ");
            rhombus.append("\n");
        }
        addSymbol(rhombus, n, "* ");
        rhombus.append("\n");

        for (int i = 1; i < n; i++) {
            addSymbol(rhombus, i, " ");
            addSymbol(rhombus, n - i, "* ");
            rhombus.append("\n");
        }
        System.out.println(rhombus);
    }

    private static void addSymbol(StringBuilder build, int i2, String s2) {
        for (int j = 0; j < i2; j++) {
            build.append(s2);
        }
    }
}
