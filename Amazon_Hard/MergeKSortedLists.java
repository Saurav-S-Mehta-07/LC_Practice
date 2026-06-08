package Amazon_Hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (Node node : lists) {
            if (node != null)
                pq.add(node);
        }

        Node head = new Node(-1);

        Node ptr = head;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next != null)
                pq.add(node.next);
        }

        ptr = head.next;

        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }

    public static void mergeKLists2(Node[] lists) {
        int l = 0, r = lists.length - 1;
        Node ptr = mergeSort(lists, 0, r);
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }

    public static Node mergeSort(Node[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l < r) {
            int mid = (l + r) / 2;
            Node left = mergeSort(lists, l, mid);
            Node right = mergeSort(lists, mid + 1, r);
            Node result = merge(left, right);
            return result;
        }
        return null;
    }

    public static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node ptr = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                ptr.next = left;
                left = left.next;
            } else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }

        if (left == null)
            ptr.next = right;
        else
            ptr.next = left;

        return dummy.next;

    }

    public static void mergeKLists3(Node[] lists){
        for(int i = 1; i<lists.length; i++){
            lists[0] = merge(lists[0], lists[i]);
        }
        Node ptr = lists[0];
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }
    

    public static void main(String[] args) {
        int k = 3;
        Node[] lists = new Node[k];

        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(0);
        l2.next = new Node(2);
        l2.next.next = new Node(4);

        Node l3 = new Node(1);
        l3.next = new Node(3);
        l3.next.next = new Node(7);

        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        mergeKLists3(lists);
    }
}
