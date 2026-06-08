package Amazon_Medium;

public class FlattenBTtoLL{
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public static void preorderTraversal(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static Node findRightMostNode(Node C){
        while(C.right!=null){
            C = C.right;
        }
        return C;
    }

    public static Node flatternBTtoLL(Node root){
        Node R = root;
        while(R!=null){
          Node C = R.left;
          if(C!=null){
            C = findRightMostNode(C);
            C.right = R.right;
            R.right = R.left;
            R.left = null;
          }
          R = R.right;
        }
        return root;
    }
    

    public static void main(String[]args){
         Node root = new Node(1);
         root.left = new Node(2);
         root.left.left = new Node(3);
         root.left.left.left = new Node(4);
         root.left.left.right = new Node(5);


         root.right = new Node(6);
         root.right.right = new Node(10);
         root.right.left = new Node(7);
         root.right.left.left = new Node(8);
         root.right.left.right = new Node(9);

         root = flatternBTtoLL(root);

         Node curr = root;
         while(curr != null){
           System.out.print(curr.val + " ");
           curr = curr.right;
        }
    }
}