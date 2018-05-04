package other;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/smallest-greater-elements-in-whole-array/
public class NextGreaterElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] inputArr = new int[len];

        for (int i = 0; i < len; i++) {
            inputArr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            sortedMap.put(inputArr[i], inputArr[i]);
        }

        for (int i = 0; i < len; i++) {
            System.out.println(sortedMap.higherKey(inputArr[i]));
        }
    }
}
