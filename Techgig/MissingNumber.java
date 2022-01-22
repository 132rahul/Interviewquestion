package Techgig;

public class MissingNumber {
    public static void main(String[] args) {
        int[] a = {0, 2, 3};
        System.out.println(missingNumber(a));
    }
    public static int missingNumber(int[] nums) {
        int sum=0;
        int a=nums.length;
        int b=a+1;
        int val=(a*b)/2;
        for(int i=0;i<a;i++){
            sum=nums[i]+sum;
        }
        return val-sum;
    }
}
