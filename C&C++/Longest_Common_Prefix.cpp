/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.


# Intuition
The problem asks for the longest common prefix among an array of strings. A trie (prefix tree) is a natural data structure to use for efficiently storing and retrieving strings with common prefixes.

# Approach
We build a trie from all the strings in the input array. Then, we traverse the trie from the root, following paths where there is only one child node at each step until we reach a leaf or a node with multiple children. This path represents the longest common prefix.

# Complexity
- Time complexity: O(N * M)
  - Where N is the number of strings and M is the length of the shortest string in the array.

- Space complexity: O(N * M)
  - In the worst case, we may need to store all characters of all strings in the trie.
*/

#include <iostream>
#include <vector>

using namespace std;

struct trie 
{
    trie* children[26];
    bool isEnd;
    
    trie()
    {
        for(int i = 0; i < 26; i++)
            children[i] = nullptr;
        isEnd = false;
    }
};

string longestCommonPrefix(vector<string>& strs)
{
    trie* root = new trie();
    for (const string& s : strs)
    {
        trie* current = root;
        for (char c : s)
        {
            int index = c - 'a';
            if (!current->children[index])
                current->children[index] = new trie();
            current = current->children[index];
        }
        current->isEnd = true;
    }

    string prefix = "";
    trie* current = root;
    while (true)
    {
        int count = 0;
        int index = -1;
        for (int i = 0; i < 26; i++)
        {
            if (current->children[i])
            {
                count++;
                index = i;
            }
        }
        if (count == 1 && !current->isEnd)
        {
            prefix += char('a' + index);
            current = current->children[index];
        }
        else
            break;
    }
    return prefix;
}

int main()
{
    vector<string> strs = {"flower", "flow", "flight"};
    cout << longestCommonPrefix(strs) << endl; // Output: "fl"
    return 0;
}