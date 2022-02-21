package WorkingwithAbstractionExercise.Problem3CardswithPower;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Rank rank = Rank.valueOf(s.nextLine());
        Suit suit = Suit.valueOf(s.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d" , rank , suit , rank.getRank() + suit.getSuit());
    }
}
