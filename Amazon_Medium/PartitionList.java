package Amazon_Medium;

public class PartitionList {

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static void printList(Node head){
        Node ptr  = head;
        while(ptr!=null){
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static Node partition(Node head, int x){
        Node before = new Node(0);
        Node after = new Node(0);

        Node bp = before, ap = after, ptr = head;

        while(ptr!=null){
            if(ptr.val < x){
                bp.next = ptr;
                bp = bp.next;
            }
            else{
                ap.next = ptr;
                ap = ap.next;
            }
            ptr = ptr.next;
        }

        ap.next = null;
        bp.next = after.next;
        return before.next;
    }
   public static void main(String[] args) {
      Node head = new Node(1);
      head.next = new Node(4);
      head.next.next = new Node(3);
      head.next.next.next = new Node(2);
      head.next.next.next.next = new Node(5);
      head.next.next.next.next.next = new Node(2);

      head = partition(head,3);
      printList(head);

   }   
}
