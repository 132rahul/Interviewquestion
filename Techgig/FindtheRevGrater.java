package Techgig;

import java.util.Scanner;

public class FindtheRevGrater {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        a = findrev(a);
        b = findrev(b);
        if (a >= b) {
            System.out.println(a);
        } else if (b > a) {
            System.out.println(b);
        }
    }

    private static int findrev(int number) {
        //int rev;
        int rev = 0;
        while (number != 0) {
            int remainder = number % 10;
            rev = rev * 10 + remainder;
            number = number / 10;
        }
        return rev;

    }
}
