package WorkingwithAbstractionExercise.Problem5JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowSize = dimensions[0];
        int colSize = dimensions[1];

        int[][] matrix = new int[rowSize][colSize];

        int value = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = value++;
            }
        }
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] peterCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            evilMove(matrix, evilCoordinates);

            sum = peterMoveAndCollect(matrix, sum, peterCoordinates);
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static void evilMove(int[][] matrix, int[] evilCoordinates) {
        int evilRow = evilCoordinates[0];
        int evilCol = evilCoordinates[1];
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long peterMoveAndCollect(int[][] matrix, long sum, int[] peterCoordinates) {
        int peterRow = peterCoordinates[0];
        int peterCol = peterCoordinates[1];

        while (peterRow >= 0 && peterCol < matrix[1].length) {
            if (peterRow < matrix.length && peterCol >= 0 && peterCol < matrix[0].length) {
                sum += matrix[peterRow][peterCol];
            }
            peterCol++;
            peterRow--;
        }
        return sum;
    }
}
