package Techgig;
import java.util.*;

public class FindSubsequenc {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String virus = sc.next().toLowerCase();
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            list.add(sc.next().toLowerCase());
        }
        Iterator iterator = findreport(virus, num, list).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static List<String> findreport(String virus, int num, List<String> list) {
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (checkinput(virus, list.get(i))) {
                list1.add("POSITIVE");
            } else {
                list1.add("NEGATIVE");
            }
        }
        return list1;
    }

    private static boolean checkinput(String vn, String bn) {
        boolean fg = false;
        int m = vn.length();
        int n = bn.length();
        int j = 0, i = 0;
        if (n > m||n==0) {
            return false;
        }
        while (i < m && j < n) {
            if (vn.charAt(i) == bn.charAt(j)) {
                fg = true;
                i++;
                j++;
            } else {
                fg = false;
                i++;
            }
        }
        return fg;
    }
}
