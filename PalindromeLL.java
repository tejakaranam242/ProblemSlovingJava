import java.util.Scanner;
public class PalindromeLL {
    public Node reverseList(Node head) {
        if(head == null || head.next==null) return head;
        Node newNode = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
    }
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newNode = reverseList(slow.next);
        Node first = head;
        Node second = newNode;
        while(second!=null){
            if(first.data!=second.data){
                reverseList(newNode);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newNode);
        return true;
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
        PalindromeLL obj = new PalindromeLL();
        System.out.print("Result: "+obj.isPalindrome(head));
    }
}
