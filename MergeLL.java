public class MergeLL {
    Node sortedMerge(Node head1, Node head2) {
        Node pointer1 = head1;
        Node pointer2 = head2;
        Node dummy = new Node(-1);
        Node current = dummy;
        while(pointer1!=null&&pointer2!=null){
            if(pointer1.data<pointer2.data){
                current.next = pointer1;
                current = pointer1;
                pointer1 = pointer1.next;
            }
            else{
                current.next = pointer2;
                current = pointer2;
                pointer2 = pointer2.next;
            }
        }
        if(pointer1!=null) current.next = pointer1;
        else current.next = pointer2;
        return dummy.next;
    }
}
