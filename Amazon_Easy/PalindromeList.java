package Amazon_Easy;

public class PalindromeList {
    
    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverseRight(Node head){
        Node curr = head;
        Node next;
        Node prev = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head){
        if(head==null || head.next == null) return true;

        //find mid node
        Node mid = findMid(head);

        //reverse right part
        Node rightHead = reverseRight(mid.next);

        mid.next = null;


        //compare
        Node leftHead = head;

        while(leftHead!=null && rightHead!=null){
            if(leftHead.val != rightHead.val) return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }


        return true;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next= new Node(2);
        head.next.next.next = new Node(1);


        System.out.print(isPalindrome(head));
    }
}
