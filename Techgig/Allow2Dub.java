package Techgig;

import java.util.*;

public class Allow2Dub {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 4, 4, 4, 4, 5, 3, 3, 5};
        //Used Map<K,V>,List,Array
        // a = allow2dub(a);

        //Used SameArray
        a = allow2dubWithsamArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    private static int[] allow2dubWithsamArray(int[] a) {
        Arrays.sort(a);
        int val = 0;
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] != a[i + 2]) {
                a[val++] = a[i];
            }
        }
        a[val++] = a[a.length - 2];
        a[val++] = a[a.length - 1];
        int[] new_array = new int[val];

        for (int i = 0; i < val; i++) {
            new_array[i] = a[i];
        }
        return new_array;
    }

    public static int[] allow2dub(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        // List list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int b = 0;

        for (Map.Entry etr : map.entrySet()) {
            if ((int) etr.getValue() >= 2) {
                //  list.add((int) etr.getKey());
                //  list.add((int) etr.getKey());
                a[b++] = (int) etr.getKey();
                a[b++] = (int) etr.getKey();
            } else {
                //  list.add((int) etr.getKey());
                a[b++] = (int) etr.getKey();
            }
        }
        // System.out.println(list);
        int[] d = new int[b];
        for (int i = 0; i < b; i++) {
            d[i] = a[i];
        }
        return d;
    }
}
