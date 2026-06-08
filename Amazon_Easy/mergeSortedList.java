package Amazon_Easy;

public class mergeSortedList{

    public static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node mergeSortedList(Node list1, Node list2){
        Node head = new Node(0);
        Node ptr = head;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                ptr.next = list1;
                list1 = list1.next;
            }
            else{
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        if(list1!=null){
            ptr.next = list1;
        }else{
            ptr.next = list2;
        }
        return head.next;
    }

    public static void printList(Node head){
        Node ptr = head;

        while(ptr!=null){
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.print("\n");
    }

    public static void main(String []args){
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);
        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);
        list2.next.next.next = new Node(5);
        list2.next.next.next.next = new Node(6);

        Node head = mergeSortedList(list1, list2);
        printList(head);
    }
}