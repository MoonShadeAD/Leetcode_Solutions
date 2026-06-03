/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
public class Find_Range
{
    private int findFirst(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                ans = mid;
                right = mid - 1;
            }
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    private int findLast(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                ans = mid;
                left = mid + 1;
            }
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target)
    {
        return new int[] {
            findFirst(nums, target),
            findLast(nums, target)
        };
        // boolean first = false, last = false;
        // int temp1 = -1, temp2 = -1;
        // int start = 0, end = nums.length-1;
        // for (int k = 0; k<nums.length; k++)
        // {
        //     if(!first)
        //     {
        //         if (nums[start] == target)
        //         {
        //             temp1 = start;
        //             first = true;
        //         }
        //         start++;
        //     }
        //     if (!last)
        //     {
        //         if (nums[end] == target)
        //         {
        //             temp2 = end;
        //             last = true;
        //         }
        //         end--;
        //     }
        //     if (last && first) return new int[]{temp1, temp2};
        // }
        // return new int[]{temp1, temp2};
    }
    public static void main(String[] args)
    {
        Find_Range obj = new Find_Range();
        int[] arr = {5,7,7,8,8,10};
        int target = 5;
        for (int i : obj.searchRange(arr, target))
            System.out.print(i+" ");
    }
}
