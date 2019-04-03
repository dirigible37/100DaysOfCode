/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;
        ListNode retStart = new ListNode(0);
        ListNode curRet = retStart;
        int mod = 0;
        while(l1_cur != null || l2_cur != null){
            
            if(l2_cur == null) {
                curRet.val = l1_cur.val + mod;
                l1_cur = l1_cur.next;   
            }else if(l1_cur == null){
                curRet.val = l2_cur.val + mod;
                l2_cur = l2_cur.next;
            }else{
                curRet.val = l1_cur.val + l2_cur.val + mod;
                l1_cur = l1_cur.next;
                l2_cur = l2_cur.next;
            }    

            if(l1_cur != null || l2_cur != null)
                curRet.next = new ListNode(0);
            
            mod = 0;
            if (curRet.val >= 10) {
                mod = 1;
                if(l1_cur == null && l2_cur == null)
                    curRet.next = new ListNode(1);
                curRet.val -= 10;
            }

            curRet = curRet.next;
        }
        
        return retStart;
    }
}