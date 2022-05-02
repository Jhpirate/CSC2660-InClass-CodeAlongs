package week_1_lash_3_18;

import java.util.Random;

class Die {
    private Random rand = new Random();
    private int value;

    public Die() {
        value = rand.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}


public class DiceRollTest {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.printf("%s\t", new Die().getValue());
        }
    }
}
