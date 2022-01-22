package Java8Conpt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
    public static void main (String args[]){
        System.out.println("Lambda Expressions");
        List<String> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        List<String> l3=new ArrayList<>();
        l1.add("qw");
        l1.add("er");
        l1.add("ui");
        l2.add("as");
        l2.add("sd");
        l2.add("fg");
        l2.add("rt");
        for(String str: l1){
           // System.out.println(l1 + " : "+l2);
            System.out.println(str);
        }
        for(int i=0,j=0,k=0; i<l1.size() && j<l1.size() ; ++i,++j){
            System.out.println(l1.get(i)+" : "+l2.get(j));
        }

    }
}
