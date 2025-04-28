package generator;

import java.util.Random;

public class RandomSelector {

    public static String getRandomFromArray(String[] array) {
        Random r = new Random();
        return array[r.nextInt(array.length)];
    }

    public static int getRandomIntInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt(min, max);
    }

}
