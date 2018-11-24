/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal, null);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node linkNode = head;
        Node maxNode = head; // maxNode is useful than the minNode
        Node minNode = head;
        if(linkNode.next == head){  // means it only has one item
            linkNode.next = newNode;
            newNode.next = head;
            return head;
        }
        // the list has more than one item.
        linkNode = linkNode.next;
        while(linkNode.next != head.next){
            maxNode = (maxNode.val <= linkNode.val) ? linkNode : maxNode;
            minNode = (minNode.val >= linkNode.val) ? linkNode : minNode;
            linkNode = linkNode.next;
        }
        // if all of them have the same value
        if(maxNode.val == minNode.val){
            newNode.next = maxNode.next;
            minNode.next = newNode;
            return head;
        }
        // else not
        if(newNode.val < minNode.val || newNode.val > maxNode.val){
            newNode.next = minNode;
            maxNode.next = newNode;
            return head;
        } else{
            linkNode = head;
            boolean oneRound = false;
            while(!oneRound){
                if(linkNode.val <= newNode.val && newNode.val <= linkNode.next.val){
                    newNode.next = linkNode.next;
                    linkNode.next = newNode;
                    return head;
                }
                linkNode = linkNode.next;
                if(linkNode== head) oneRound = true;
            }
        }
        return head;
        
    }
}
