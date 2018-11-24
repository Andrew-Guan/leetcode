class Solution {
     public Node insert(Node head, int insertVal) {
        if (head == null) {
        	Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }
    
        Node currNode = head;
        Node nextNode = head.next;
        do {
	         if(currNode.val <= insertVal && insertVal <= nextNode.val) break;
	         if (nextNode.val < currNode.val && (insertVal >= currNode.val || insertVal <= nextNode.val)) break;
	            currNode = nextNode;
	            nextNode = nextNode.next;
        } while (currNode != head);

        Node insert = new Node(insertVal, nextNode);
        currNode.next = insert;
        
        return head;
	 }
}
