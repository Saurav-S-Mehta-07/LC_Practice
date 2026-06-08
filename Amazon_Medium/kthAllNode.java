package Amazon_Medium;

public class kthAllNode {

    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public static void printKDistanceNodeDown(Node root, int k){
        if(root == null || k<0) return;
        if(k==0){
            System.out.print(root.val + " ");
            return;
        }
        printKDistanceNodeDown(root.left, k-1);
        printKDistanceNodeDown(root.right, k-1);
    }

    public static int printAllKthNode(Node root, Node  target, int k){
        if(root == null) return -1;
        if(root == target){
            printKDistanceNodeDown(root,k);
            return 0;
        }

        int dl = printAllKthNode(root.left, target, k);

        if(dl != -1){
            if(dl+1 == k){
                System.out.print(root.val + " ");
            }
            else{
                printKDistanceNodeDown(root.right, k-dl-2);
            }
            return 1 + dl;
        }

        int dr = printAllKthNode(root.right, target, k);

        if(dr != -1){
            if(dr+1 == k){
                System.out.print(root.val + " ");
            }
            else{
                printKDistanceNodeDown(root.left, k-dr-2);
            }
            return 1 + dr;
        }
        
        return -1;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        root.right = new Node(1);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        
        Node target = root.left;

        printAllKthNode(root, target, 2);
    }
}
