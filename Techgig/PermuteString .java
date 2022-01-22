package Techgig;

import java.util.*;

class PermuteString {

    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        System.out.println("All the permutations of the string are: ");
        generatePermutation(str, 0, len);
        System.out.println(set.size());
    }

    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    public static void generatePermutation(String str, int start, int end) {

        if (start == end - 1) {
            //list.add(str);
            if (!(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' ||
                    str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U')) {
                set.add(str);
            }
        } else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i);
                generatePermutation(str, start + 1, end);
                str = swapString(str, start, i);
            }
        }

    }
}