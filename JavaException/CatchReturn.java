package JavaException;

public class CatchReturn {
    int calc() {
        try {
            int x=12/0;
        } catch (Exception e) {
            return 1;
        }
        return 10;
    }
    public static void main(String[] args) {
        CatchReturn cr = new CatchReturn();
        System.out.println(cr.calc());
    }
}
