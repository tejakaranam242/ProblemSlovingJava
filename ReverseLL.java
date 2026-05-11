import java.util.Scanner;

public class ReverseLL {
    public Node reverseList(Node head) {
        if(head == null || head.next==null) return head;
        Node newNode = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
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
        ReverseLL obj = new ReverseLL();
        System.out.print("result:"+obj.reverseList(head));
    }
}
