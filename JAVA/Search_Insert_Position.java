/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Intuition: Binary Search Technique
Approach: To solve this problem, we can use the binary search algorithm. The idea is to repeatedly divide the search interval in half. If the value of the target is less than the item in the middle of the interval, we narrow the interval to the lower half. Otherwise, we narrow it to the upper half. We continue this process until we find the target or the interval is empty. As for the insertion point, if the target is not found, the left pointer will indicate the position where the target can be inserted to maintain the sorted order. We can solve the edge cases by checking the left and right pointers after the loop.
Complexity Analysis:
Time Complexity: O(log n), where n is the number of elements in the array. This is because we are halving the search space with each iteration.
Space Complexity: O(1), as we are using a constant amount of extra space.
 */

public class Search_Insert_Position
{
    public int searchInsert(int[] nums, int target)
    {
        int index = -1;
        int left = 0, right = nums.length;
        for (int mid = (left+right)/2; mid < right && mid > left; mid = (left+right)/2)
        {
            if (nums[mid] == target)
            {
                index = mid;
                return index;
            }
            else if (nums[mid] > target)
            {
                right = mid;
                index = mid;
            }
            else
            {
                left = mid;
                index = mid+1;
            }
        }
        if (target <= nums[left])
            index = left;
        else if (target > nums[right-1])
            index = right;

        return index;
    }
    public static void main(String[] args)
    {
        Search_Insert_Position obj = new Search_Insert_Position();
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(obj.searchInsert(nums, target));
    }
}