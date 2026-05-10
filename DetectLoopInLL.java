import java.util.Random;
import java.util.Scanner;

//public class Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        this.next = null;
//    }
//}
public class DetectLoopInLL {
    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value = scanner.nextInt();
        Node head = new Node(value);
        Node temp = head;
        Random random = new Random();
        int randomIndex = random.nextInt(n);
        Node loopNode = null;
        for(int i=1;i<n;i++){
            value = scanner.nextInt();
            Node newNode = new Node(value);
            if(i==n){
                loopNode = newNode;
            }
            temp.next = newNode;
            temp = newNode;
        }
        temp.next = loopNode;
        DetectLoopInLL obj = new DetectLoopInLL();
        System.out.print("Result:"+obj.detectLoop(head));
    }
}
