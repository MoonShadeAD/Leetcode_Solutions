/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/

public class Remove_element
{
    public int removeElement(int[] nums, int val)
    {
        // int ctr = 0;
        // for (int k : nums)
        //     if (k == val)
        //         ctr++;

        // int pos = 0;
        // for (int i = 0; i<nums.length; i++)
        // {
        //     pos = i;
        //     if (nums[i] == val)
        //     {
        //         while(nums[pos] == val)
        //             if (pos != nums.length-1) pos++;
        //             else break;
        //         nums[i] = nums[pos];
        //         nums[pos] = val;
        //     }
        // }
        // return nums.length-ctr;
        int valid = 0;
        for (int index = 0; index<nums.length; index++)
        {
            if (nums[index] != val)
            {
                nums[valid]=nums[index];
                valid++;
            }
        }

        for (int i : nums)
            System.out.print(i+" ");

        return valid;
    }
    public static void main(String[] args)
    {
        Remove_element obj = new Remove_element();
        int val = 2;
        int[] value = {0,1,2,2,3,0,4,2};
        System.out.println(obj.removeElement(value, val));
    }
}
