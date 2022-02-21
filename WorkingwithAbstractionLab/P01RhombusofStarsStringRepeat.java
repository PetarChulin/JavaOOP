import java.util.Scanner;

public class P01RhombusofStarsStringRepeat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder rhombus = new StringBuilder();
        int n = Integer.parseInt(s.nextLine());
        printRhombus(rhombus, n);
    }

    private static void printRhombus(StringBuilder rhombus, int n) {
        for (int i = 0; i < n; i++) {
            rhombus.append(" ".repeat(n - i)).append("* ".repeat(i)).append("\n");
        }
        rhombus.append("* ".repeat(Math.max(0, n))).append("\n");

        for (int i = 1; i < n; i++) {
            rhombus.append(" ".repeat(i)).append("* ".repeat(n - i)).append("\n");
        }
        System.out.println(rhombus);
    }
}

