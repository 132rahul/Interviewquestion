//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Output: Because nums[0] + nums[1] == 9, we return [0, 1].

//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]

import java.util.HashMap;
import java.util.Map;

public class Twosum {
    public static void main(String args[]) {
        int[] nums = {3, 4, 5, 2, 1};
        int target = 6;
//        Using brute force: solution one.
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    System.out.println(i+" , "+ j);
//                }
//            }
//        }

// using hashtable(Hashmap): solution: 2
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++)
            System.out.print(" " + nums[i]);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && (map.get(complement) != i)) {
                System.out.println(i + " , " + map.get(complement));
                //i, map.get(complement);
            }
        }

    }
}
