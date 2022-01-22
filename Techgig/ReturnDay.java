package Techgig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReturnDay {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(sc.nextInt());
            l1.add(sc.nextInt());
            l1.add(sc.nextInt());
            list.add(l1);
        }
        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i).get(0);
            int d = list.get(i).get(1);
            int n = list.get(i).get(2);
            System.out.println(((n - c) / (c - d)) + 1);
        }
        /*Iterator iterator = finddays(list).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
    }

    private static List<Integer> finddays(List<List<Integer>> list) {
        List<Integer> lt = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int c = list.get(i).get(0);
            int d = list.get(i).get(1);
            int n = list.get(i).get(2);
            lt.add(calulate(c, d, n));
        }
        return lt;
    }

    private static int calulate(int c, int d, int n) {
        return ((n - c) / (c - d)) + 1;
    }

   /* public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] tj = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            System.out.println(find(tj, 1));
        }
    }

    static int find(int[] tj, int res) {
        for (int i = tj[2]; i > 0; ) {
            int t = i - tj[0];
            if (t > 0) {
                i = t + tj[1];
            } else break;
            res++;
        }
        return res;
    }*/
}
