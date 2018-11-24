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
        ListNode connector;
        connector = head;
        
        // Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
        //     public int compare(ListNode L1,ListNode L2){
        //         if(L1.val < L2.val) {
        //             return -1;
        //         }else if(L1.val > L2.val){
        //             return 1;
        //         }else{
        //             return 0;
        //         }
        //     }
        // };
        PriorityQueue<ListNode> pq= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        
        
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(20, listNodeComparator);
        for(int i = 0; i< num; i++){
            while(lists[i] != null){
                pq.add(lists[i]);
                if(lists[i].next != null){
                   lists[i] = lists[i].next; 
                }
            }
        }
        while(pq.peek()!= null){
            ListNode tmp = pq.poll();
            connector.next = tmp;
            connector = tmp;
        }
        return head.next;
    }


}
// class listNodeComparator implements Comparator<ListNode>{
//     public int compare(ListNode L1,ListNode L2){
//         if(L1.val < L2.val) {
//             return -1;
//         }else if(L1.val > L2.val){
//             return 1;
//         }else{
//             return 0;
//         }
//     }
// }
