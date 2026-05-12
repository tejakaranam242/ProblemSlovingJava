public class DeleteNodeLL {
    Node deleteNode(Node head, int x) {
        if(x==1) return head.next;
        Node current = head;
        Node previous = null;
        while(x>1){
            previous = current;
            current = current.next;
            x--;
        }
        previous.next = current.next;
        current.next = null;
        return head;
    }
}
