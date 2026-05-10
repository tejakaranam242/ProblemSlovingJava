import java.util.Scanner;

public class MiddleOfLL {
    public int middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
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
        MiddleOfLL obj = new MiddleOfLL();
        System.out.print("Result: "+obj.middleNode(head));
    }
}
