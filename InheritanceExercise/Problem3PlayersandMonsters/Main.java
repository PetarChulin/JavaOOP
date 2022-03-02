package hero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        String name = s.nextLine();
        int age = Integer.parseInt(s.nextLine());

        SoulMaster master = new SoulMaster(name , age);
        System.out.println(master);
    }
}
