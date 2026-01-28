/**
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
public class Longest_Non_repeating_Substring
{
    public boolean contains(char[] seen, char c)
    {
        for (char ch : seen)
        {
            if (ch == c)
            {
                return true;
            }
        }
        return false;
    }
    public int lengthOfLongestSubstring(String s)
    {
        //Inefficient
        // int maxLength = 0;
        // int n = s.length();

        // for (int i = 0; i < n; i++)
        // {
        //     char[] seen = new char[256];
        //     int currentLength = 0;

        //     for (int j = i; j < n; j++)
        //     {
        //         char currentChar = s.charAt(j);
        //         if (!contains(seen, currentChar))
        //         {
        //             seen[currentLength] = currentChar;
        //             currentLength++;
        //             maxLength = Math.max(maxLength, currentLength);
        //         }
        //         else
        //         {
        //             break;
        //         }
        //     }
        // }
        // return maxLength;

        //Hashset Approach
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int substr = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
            if (!set.contains(currentChar))
            {
                set.add(currentChar);
                substr++;
                maxLength = Math.max(maxLength, substr);
            }
            else
            {
                while (set.contains(currentChar))
                {
                    set.remove(s.charAt(i - substr));
                    substr--;
                }
                set.add(currentChar);
                substr++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args)
    {
        Longest_Non_repeating_Substring obj = new Longest_Non_repeating_Substring();
        String s = "abcabcbb";
        System.out.println("Length of Longest Non-repeating Substring: " + obj.lengthOfLongestSubstring(s));
    }
}