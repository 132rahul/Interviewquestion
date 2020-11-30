import java.util.Scanner;

public class Pyraminde {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int terms = sc.nextInt();
        int t = 0;
        while (t < 2) {
            for (int i = 0; i <= terms; i++) {
                for (int j = (terms - i); j >= 1; j--) {
                    System.out.print(" ");
                }
                for (int q = 0; q <= i; q++) {
                    System.out.print("* ");
                }

                System.out.println();
            }
            for (int i = 1; i <= terms; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(" ");
                }
                for (int q = terms; q >= i; q--) {
                    System.out.print("* ");
                }

                System.out.println();
            }
            t++;
        }
    }
}
