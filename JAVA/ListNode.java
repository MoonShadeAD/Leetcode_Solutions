/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 
Complexity Analysis:
Time Complexity: O(n + m), where n and m are the lengths of list1 and list2 respectively. We traverse both lists once.
Space Complexity: O(1), as we are not using any additional data structures that grow with input size.
*/
public class ListNode
{
    int val;
    ListNode next;
    
    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class Merge_Two_List
{
    ListNode MergeList = new ListNode(0);

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode current = MergeList;

        while (list1 != null && list2 != null)
        {
            if (list1.val <= list2.val)
            {
                current.next = list1;
                list1 = list1.next;
            }
            else
            {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null)
            current.next = list1;
        else if (list2 != null)
            current.next = list2;

        return MergeList.next;
    }

    public static void main(String[] args)
    {
        Merge_Two_List merger = new Merge_Two_List();

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode mergedList = merger.mergeTwoLists(list1, list2);

        while (mergedList != null)
        {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}