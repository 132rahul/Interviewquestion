package Techgig;

import java.util.*;

public class FindthemaxCha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        Iterator iterator = FindMaxCh(list).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static List<Character> FindMaxCh(List<String> list) {
        List<Character> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(checkup(list.get(i)));
        }
        return list1;
    }

    public static Character checkup(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arry = s.toCharArray();
        for (int i = 0; i < arry.length; i++) {
            map.put(arry[i], map.getOrDefault(arry[i], 0) + 1);
        }
        int max = 0;
        Character sval = null;
        for (Map.Entry et : map.entrySet()) {
            int val = (int) et.getValue();
            if (max < val) {
                max = val;
                sval = (Character) et.getKey();
            }
        }
        return sval;
    }
}
