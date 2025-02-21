package proje3;


public class Hash2<K, V> {
    private static final int BASLANGIC_BOYUTU  = 16;
    private static final double YUKLEME_FAKTORU  = 0.75;

    private Node<K, V>[] table;
    private int size;

    public Hash2() {
        this.table = new Node[BASLANGIC_BOYUTU ];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key null olamaz.");
        }

        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value, null);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Key zaten varsa değeri güncelle
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }

        size++;

        // Tablo genişletme kontrolü
        if ((double) size / table.length > YUKLEME_FAKTORU ) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private int hash(K key) {
    return (key.hashCode() & 0x7FFFFFFF) % table.length;
}
    
    public boolean containsKey(K key) {
        int index = hash(key);
        Node<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private void resize() {
    int newCapacity = table.length * 2;
    Node<K, V>[] newTable = new Node[newCapacity];

    for (Node<K, V> oldNode : table) {
        while (oldNode != null) {
            Node<K, V> next = oldNode.next;

            int index = (oldNode.key.hashCode() & 0x7FFFFFFF) % newCapacity;

            oldNode.next = newTable[index];
            newTable[index] = oldNode;
            oldNode = next;
        }
    }

    table = newTable;
}

    
    public Entry<K, V>[] entrySet() {
        int size = calculateSize(); // Eleman sayısını hesapla
        Entry<K, V>[] entries = new Entry[size];
        int index = 0;

        for (Node<K, V> node : table) {
            while (node != null) {
                entries[index++] = new Entry<>(node.key, node.value);
                node = node.next;
            }
        }

        return entries;
    }

    private int calculateSize() {
        int size = 0;

        for (Node<K, V> node : table) {
            while (node != null) {
                size++;
                node = node.next;
            }
        }

        return size;
    }

    public static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
 }
}