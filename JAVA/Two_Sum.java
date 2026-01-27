/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.*/


/*
# Intuition: Use a HashMap to store elements and their indices as we iterate through the array. For each element, check if the complement (target - current element) exists in the map. If it does, return the indices. If the array is sorted, a two-pointer approach can also be used i.e starting from both ends of the array and moving towards the center based on the sum comparison with the target.


# Complexity
- Time complexity: O(n)

- Space complexity: O(n)
*/

import java.util.HashMap;
public class Two_Sum
{
    
    public int[] twoSum(int[] nums, int target)
    {
        // Works Only when the array is sorted
        // int f = 0, l = nums.length - 1;
        // while (f < l)
        //     if (nums[f] + nums[l] == target)
        //         return new int[]{f, l};
        //     else if (nums[f] + nums[l] < target)
        //         f++;
        //     else
        //         l--;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int need = target - nums[i];

            if (map.containsKey(need))
                return new int[]{map.get(need), i};

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args)
    {
        Two_Sum obj = new Two_Sum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}