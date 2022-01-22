package Techgig;

import java.util.*;

public class FindMinDistBWObj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> l1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();
            List<Integer> l2 = new ArrayList<>();
            for (int j = 0; j < n1; j++) {
                l2.add(sc.nextInt());
            }
            l1.add(l2);
        }
        System.out.println(l1);
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(findDist(l1.get(i)));
        }
    }

    private static Integer findDist(List<Integer> l3) {
        int result = 0;
        Collections.sort(l3);
        for (int i = 0; i < l3.size() - 1; i++) {
            result = l3.get(i) - l3.get(i + 1) + result;
        }
        return result * -1;
    }
}
