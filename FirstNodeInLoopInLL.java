import java.util.Random;
import java.util.Scanner;
public class FirstNodeInLoopInLL {
    public int cycleStart(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.data;
            }
        }
        return -1;
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
        FirstNodeInLoopInLL obj = new FirstNodeInLoopInLL();
        System.out.print("Result: "+obj.cycleStart(head));
    }
}
