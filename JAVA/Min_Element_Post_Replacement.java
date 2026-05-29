/*
You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.

 

Example 1:

Input: nums = [10,12,13,14]

Output: 1

Explanation:

nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

Example 2:

Input: nums = [1,2,3,4]

Output: 1

Explanation:

nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

Example 3:

Input: nums = [999,19,199]

Output: 10

Explanation:

nums becomes [27, 10, 19] after all replacements, with minimum element 10.

 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 10^4 */

public class Min_Element_Post_Replacement
{
    public int sum_of_digit(int n)
    {
        int sum = 0;
        while (n!=0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int minElement(int[] nums)
    {
        for (int i = 0; i<nums.length; i++)
            nums[i] = sum_of_digit(nums[i]);
        
        int min = Integer.MAX_VALUE;
        for (int i : nums)
            if (min > i)
                min = i;
        return min;
    }
    public static void main(String[] args)
    {
        Min_Element_Post_Replacement obj = new Min_Element_Post_Replacement();
        int arr[] = {999,19,199};
        System.out.print(obj.minElement(arr));
    }
}
