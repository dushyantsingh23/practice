package util;

import java.util.Random;
import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static Integer getInteger() {
        System.out.println("Input Integer");
        return sc.nextInt();
    }
    private static String[] literals = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
            "v", "w", "x", "y", "z"};//

    public static String getRandomString(Integer len) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(literals[getRandomInteger(literals.length)]);
        }
        return sb.toString();
    }

    public static Integer getRandomInteger(Integer bound) {
        return random.nextInt(bound);
    }
}
