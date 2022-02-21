package WorkingwithAbstractionExercise.Problem3CardswithPower;

public enum Suit {

    CLUBS (0), DIAMONDS (13), HEARTS(26), SPADES(39);

    private int power;

    Suit(int power) {
        this.power = power;
    }
    public int getSuit() {
        return power;
    }
}
