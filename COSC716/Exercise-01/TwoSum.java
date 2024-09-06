/**
 * TWO SUM
 * 
 * @author Ata Tangban
 * 
 * @description
 *    This class will return the indices of two numbers such that they add
 *    up to a specific target.
 * 
 * @packages
 *    Java Utilities (HashMap, Map)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; 
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        
        int[] result = solution.twoSum(nums, target);
        
        // Output the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}