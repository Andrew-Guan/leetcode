/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int num = lists.length;
        ListNode head = new ListNode(0);
        ListNode connect = new ListNode(0);
        connect = head;
        while(true){
            int existNum = 0;
            for(int i = 0; i < num; i++){
                if(lists[i] != null) existNum++;
            }
            if(existNum == 0) break;
            
            ListNode current = new ListNode(Integer.MAX_VALUE);
            int pickNum = 0;
            for(int i = 0; i < num; i++){
                if(lists[i] != null){
                    if(lists[i].val < current.val){
                        current.val = lists[i].val;
                        pickNum = i;
                        
                    }
                }
            }
            current = lists[pickNum];
            lists[pickNum] = lists[pickNum].next;
            
            connect.next = current;
            connect = current;
        }
        return head.next;
    }

}
