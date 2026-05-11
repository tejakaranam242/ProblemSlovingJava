import java.util.Scanner;
public class LinkedListGroupReverse {
    public void printList(Node head){
        Node current = head;
        while(current!=null){
            System.out.print(" "+current.data);
            current = current.next;
        }
    }
    public Node reverseLL(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public Node findKthNode(Node head, int k){
        k-=1;
        while(head!=null && k>0){
            head = head.next;
            k--;
        }
        return head;
    }
    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node nextNode;
        Node previous = null;
        while(temp!=null){
            Node kthNode = findKthNode(temp,k);
            if(kthNode == null) {
                Node newHead = reverseLL(temp);
                if(previous == null)
                    head = newHead;
                else
                    previous.next = newHead;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head) head=kthNode;
            else previous.next = kthNode;
            previous = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value = scanner.nextInt();
        Node head = new Node(value);
        Node temp = head;
        for(int i=1;i<n;i++){
            value = scanner.nextInt();
            Node newNode = new Node(value);
            temp.next = newNode;
            temp = newNode;
        }
        int k = scanner.nextInt();
        LinkedListGroupReverse obj = new LinkedListGroupReverse();
        Node result = obj.reverseKGroup(head,k);
        obj.printList(result);
    }
}
