import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class MinimumSwape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
      //  System.out.println(APminSwaps(str));
        System.out.println(SwipmeApp(str));
    }

    private static int SwipmeApp(String str) {
        char[] arr = str.toCharArray();
        char[] temp = arr.clone();
        int count =0;
        Arrays.sort(temp);
        System.out.println(temp);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=temp[i]){
                count++;
            }
        }
        return count-1;
    }

    static int APminSwaps(String str) {
        char[] arr = str.toCharArray();
        char[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.println(temp);
        HashMap<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            pos.put(arr[i], i);
        }
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (temp[i] != arr[i]) {
                int ind = pos.get(temp[i]);
                Character tempValue = arr[i];
                arr[i] = arr[ind];
                arr[ind] = tempValue;
                pos.put(arr[i], i);
                pos.put(arr[ind], ind);
                swaps++;
            }
        }
        return swaps;
    }
}
