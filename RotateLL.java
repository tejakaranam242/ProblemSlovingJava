public class RotateLL {
    public Node rotate(Node head, int k) {
        int LLLength = 1;
        Node current = head;
        while(current.next!=null){
            LLLength++;
            current=current.next;
        }
        k=k%LLLength;
        if(k==0) return head;
        current.next=head;
        current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
}
