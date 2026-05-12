public class CopyList {
    public void addBetweenNodes(Node head){
        Node current = head;
        while(current!=null){
            Node copyNode = new Node(current.data);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }
    }
    public void connectToRandom(Node head){
        Node current=head;
        while(current!=null){
            Node copyNode = current.next;
            if(current.random!=null){
                copyNode.random = current.random.next;
            }
            else{
                copyNode.random = null;
            }
            current = current.next.next;
        }
    }
    public Node getCloneList(Node head){
        Node current = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(current!=null){
            res.next = current.next;
            res = res.next;
            current.next = current.next.next;
            current = current.next;

        }
        return dummy.next;
    }
    public Node cloneLinkedList(Node head) {
        if(head== null) return head;
        addBetweenNodes(head);
        connectToRandom(head);
        return getCloneList(head);
    }
}