/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
*/

public class Container_MaxWater
{
    public int min(int a, int b)
    {
        if (a<b)
            return a;
        else return b;
    }
    public int maxArea(int[] height)
    {
        int left = 0, right = height.length - 1, area = -1;
        for (int elem : height)
        {
            if (min(height[left],height[right])*(right-left) > area)
                area = min(height[left],height[right])*(right-left);

            if(min(height[left],height[right]) == height[left])
                left++;
            else right--;
        }
        return area;
    }
    public static void main(String args[])
    {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        Container_MaxWater obj = new Container_MaxWater();
        System.out.println(obj.maxArea(arr));
    }
}
