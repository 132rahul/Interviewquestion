package Techgig;
import java.util.*;

public class CoinCount {
    static List<List<Integer>> list=new ArrayList<>();
    public static int count(int[] S, int N){
        int a=N-12;
        int res=0;
        if(a<0){
            return res;
        }
        if(a>=0){
            res++;
        }
        res+=a/3;
        res+=a/8;

        return res;
    }

   // list.add(list1);

    public static void main(String[] args)
    {
        int[] S = { 1, 2, 3 };
        int N = 12;
        System.out.println( count(S, N));
        //System.out.println(list);

    }
}
