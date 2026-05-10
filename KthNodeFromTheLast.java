import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class KthNodeFromTheLast {
    int getKthFromLast(Node head, int k) {
        Node slow = head;
        Node fast = head;
        for(int i=0;i<k;i++){
            if(fast==null) return -1;
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow==null) return -1;
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
        int k = scanner.nextInt();
        KthNodeFromTheLast obj = new KthNodeFromTheLast();
        System.out.print("Result: "+obj.getKthFromLast(head,k));
    }
}
