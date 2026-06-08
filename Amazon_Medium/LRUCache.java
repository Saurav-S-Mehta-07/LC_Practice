package Amazon_Medium;

import java.util.HashMap;

public class LRUCache {

    static class LRU {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final HashMap<Integer, Node> map;

        private final Node head;
        private final Node tail;

        public LRU(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        private void insertFront(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            insertFront(node);

            return node.value;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {

                Node node = map.get(key);
                node.value = value;

                remove(node);
                insertFront(node);

                return;
            }

            if (map.size() == capacity) {

                Node lruNode = tail.prev;

                remove(lruNode);
                map.remove(lruNode.key);
            }

            Node newNode = new Node(key, value);

            insertFront(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {

        LRU lru = new LRU(2);

        lru.put(1, 1);
        lru.put(2, 2);

        System.out.println(lru.get(1)); // 1

        lru.put(3, 3);

        System.out.println(lru.get(2)); // -1

        lru.put(4, 4);

        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
    }
}