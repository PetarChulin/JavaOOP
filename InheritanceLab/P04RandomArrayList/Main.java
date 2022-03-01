package InheritanceLab.P04RandomArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        RandomArrayList randomArrayList = new RandomArrayList();

        for (int i : new int[]{1, 2, 5, 4, 12}) randomArrayList.add(i);

        System.out.println(randomArrayList.getRandomElement());
    }
}
