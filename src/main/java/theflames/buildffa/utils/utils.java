package theflames.buildffa.utils;

public class utils {

    public static int randomInt(int min, int max) {
        int range = max - min + 1;
        int rand = 0;

        // generate random numbers within 1 to 10
        for (int i = 0; i < 10; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        return rand;
    }

}
