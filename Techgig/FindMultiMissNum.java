package Techgig;
import java.util.*;

public class FindMultiMissNum {
    public static void main(String[] args) {
        int[] a = {1, 2, 1,2};
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(a));
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}