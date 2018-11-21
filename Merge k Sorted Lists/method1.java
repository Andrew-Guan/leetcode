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
        for(int i = 0; i < num-1; i++){
            lists[i+1] = merge2Lists(lists[i],lists[i+1]);
        }
        return lists[num-1];
    }
    public ListNode merge2Lists(ListNode L1, ListNode L2){
        ListNode head = new ListNode(0);
        ListNode connect = new ListNode(0);
        connect = head;
        while(L1 != null | L2 != null){
            if(L1 != null && L2 != null){
                ListNode currentNode = new ListNode(0);
                currentNode.val = (L1.val >=  L2.val) ? L2.val: L1.val;
                connect.next = currentNode;
                connect = currentNode;
                if(L1.val>=L2.val){
                    L2 = L2.next;
                }else{
                    L1 = L1.next;
                }
            }else if(L1 != null){
                connect.next = L1;
                break;
            }else if(L2 != null){
                connect.next = L2;
                break;  
            }
        }
        return head.next;
    }
}
