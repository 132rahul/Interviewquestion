package Techgig;

public class FindLastwordLength {
    public static void main(String[] args) {
        String s = " rahul kumar ghh ";
        System.out.println("The Given String :" + s);
        System.out.println("With Space Include: " + Withfindthelength(s));
        System.out.println("With NoSpace Include: " + Withoutfindthelength(s));
    }

    private static int Withoutfindthelength(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static int Withfindthelength(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}