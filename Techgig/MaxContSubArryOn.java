package Techgig;

public class MaxContSubArryOn {
    public static void main(String[] args){
        int[] a=new int[]{-2,0,-1,-3};
        Solution1 str=new Solution1();
        System.out.println(str.maxSubArray(a));

    }
}
 class Solution1{
     public int maxSubArray(int[] A) {

         int maxSoFar=A[0], maxEndingHere=A[0];
         for (int i=1;i<A.length;++i){
             maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
             maxSoFar=Math.max(maxSoFar, maxEndingHere);
         }
         return maxSoFar;
     }
}
