package Amazon_Easy;

public class intersection {

   public static class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
   }

   public static Node intersectNode(Node list1, Node list2){
    Node l1 = list1;
    Node l2 = list2;
     while(l1!=l2){
         l1 = l1.next;
         if(l1 == null) l1 = list2;
         l2 = l2.next;
         if(l2 == null) l2 = list1;
     }
     return l1;
   }
   public static void main(String[] args) {
      Node list1 = new Node(1);
      list1.next = new Node(2);
      list1.next.next = new Node(3);
      list1.next.next.next = new Node(4);

      Node list2 = new Node(5);
      list2.next = list1.next.next;
    
      Node intersect = intersectNode(list1, list2);
      System.out.print(intersect.val);
   }   
}
