import java.util.Random;
import java.util.Scanner;

public class FindIntersection {
    public Node intersectPoint(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        while(p1!=p2){
            p1 = (p1==null?head2:p1.next);
            p2 = (p2==null?head1:p2.next);
        }
        return p1;
    }
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int value = scanner.nextInt();
    Node head = new Node(value);
    Node temp = head;
    Random random = new Random();
    int randomIndex =
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
