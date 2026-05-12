public class AddLL {
    public Node reverseLL(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public Node addTwoLists(Node head1, Node head2) {
        Node pointer1 = reverseLL(head1);
        Node pointer2 = reverseLL(head2);
        Node dummy = new Node(-1);
        Node current = dummy;
        int sum = 0,carry = 0;
        while(pointer1!=null || pointer2!=null){
            sum = carry;
            if(pointer1!=null) sum+=pointer1.data;
            if(pointer2!=null) sum+=pointer2.data;
            Node sumNode = new Node(sum%10);
            carry = sum/10;
            current.next = sumNode;
            current = sumNode;
            if(pointer1!=null) pointer1=pointer1.next;
            if(pointer2!=null) pointer2=pointer2.next;
        }
        if(carry!=0){
            Node carryNode = new Node(carry);
            current.next = carryNode;
        }

        Node ans = reverseLL(dummy.next);
        while(ans != null && ans.data == 0 && ans.next != null){
            ans = ans.next;
        }
        return ans;
    }
}
