class listNode{
    int data;
    listNode next;
    listNode random;
    listNode(int data){
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
public class CopyList {
    public void addBetweenNodes(listNode head){
        listNode current = head;
        while(current!=null){
            listNode copyNode = new listNode(current.data);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }
    }
    public void connectToRandom(listNode head){
        listNode current=head;
        while(current!=null){
            listNode copyNode = current.next;
            if(current.random!=null){
                copyNode.random = current.random.next;
            }
            else{
                copyNode.random = null;
            }
            current = current.next.next;
        }
    }
    public listNode getCloneList(listNode head){
        listNode current = head;
        listNode dummy = new listNode(-1);
        listNode res = dummy;
        while(current!=null){
            res.next = current.next;
            res = res.next;
            current.next = current.next.next;
            current = current.next;

        }
        return dummy.next;
    }
    public listNode cloneLinkedList(listNode head) {
        if(head== null) return head;
        addBetweenNodes(head);
        connectToRandom(head);
        return getCloneList(head);
    }
}