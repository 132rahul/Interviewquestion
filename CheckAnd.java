import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CheckAnd {
    public static void main(String[] args) {
        System.out.println(true & true);

        System.out.println(false && true);
        Date billingStartDate ;
        Date date1 = new Date();
        System.out.println(date1);
        Date ppk;

        DataDemo d = new DataDemo("pp","ll");

      List<Integer> lt = new ArrayList<Integer>();
      if(null!=lt){
          System.out.println("yes "+lt);
      }
      //System.out.println(lt);
        List<String> lt1 = new ArrayList<>();
      String s=null;String s1="null";
      lt1.add(s);lt1.add(s1);
        System.out.println(lt1);
        System.out.println("sasa");
    }
}
