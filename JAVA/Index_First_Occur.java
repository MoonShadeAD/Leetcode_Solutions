/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class Index_First_Occur
{
    public int strStr(String haystack, String needle)
    {
        if (needle.length() > haystack.length()) return -1;

        int length = needle.length();
        
        for (int i = 0; i<=haystack.length()-length; i++)
            if (needle.equals(haystack.substring(i, i+length)))
                return i;

        return -1;
    }
    public static void main(String[] args)
    {
        Index_First_Occur obj = new Index_First_Occur();
        System.out.print(obj.strStr("sadbutsad", "sad"));
    }
}
