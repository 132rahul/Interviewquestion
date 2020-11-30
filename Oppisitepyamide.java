import java.util.Scanner;

public class Oppisitepyamide {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int terms = sc.nextInt();
        for (int i = 0; i <= terms; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int q = terms; q >= i; q--) {
                System.out.print("* ");
            }

            System.out.println();
        }


    }
}
