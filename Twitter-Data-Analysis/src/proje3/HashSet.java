
package proje3;



 public class HashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private Node<T>[] buckets;

    @SuppressWarnings("unchecked")
    public HashSet() {
        buckets = new Node[INITIAL_CAPACITY];
    }

    public void add(T data) {
        int hash = calculateHash(data);
        int index = Math.abs(hash) % buckets.length;


        Node<T> newNode = new Node<>(data);
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node<T> current = buckets[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean contains(T data) {
        if (data == null) {
        return false;  
    }
        int hash = calculateHash(data);
int index = Math.abs(hash) % buckets.length;


        Node<T> current = buckets[index];
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private int calculateHash(T data) {
       if (data == null) {
        return 0;  
    }
    return data.hashCode();

    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
    
}

