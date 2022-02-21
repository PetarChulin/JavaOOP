import java.util.Scanner;

public class P01RhombusofStarsStringRepeat {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder rhombus = new StringBuilder();
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i < n; i++) {
            rhombus.append(" ".repeat(n - i));
            rhombus.append("* ".repeat(i));
            rhombus.append("\n");
        }
        rhombus.append("* ".repeat(Math.max(0, n)));
        rhombus.append("\n");

        for (int i = 1; i < n; i++) {
            rhombus.append(" ".repeat(i));
            rhombus.append("* ".repeat(n - i));
            rhombus.append("\n");
        }
        System.out.println(rhombus);
    }
}

