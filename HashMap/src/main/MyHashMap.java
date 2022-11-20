package main;


import java.util.Arrays;
import java.util.stream.Collectors;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1<<4;
    private static final int MAXIMUM_CAPACITY = 1<<30;

    static Entry[] hashTable;

    MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n<0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n+1;
    }

    private void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(null == node) {
            hashTable[hashCode] = new Entry(key, value);
        } else {
            Entry prevNode = node;
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }

                prevNode = node;
                node = node.next;
            }
            prevNode.next = new Entry(key, value);
        }
    }

    private V get(K key) {
        System.out.println(key.hashCode());
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key == key) return (V) node.value;
            node = node.next;
        }

        return null;
    }

    public static void main(String args[]) {

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");
        map.put(7, "g");
        map.put(8, "h");
        map.put(9, "i");
        map.put(10, "j");
        map.put(15, "k");
        map.put(16, "l");
        map.put(17, "m");
        map.put(18, "n");
        map.put(19, "o");
        map.put(101, "p");
        map.put(35, "q");
        map.put(56, "r");
        map.put(67, "s");
        map.put(78, "t");
        map.put(39, "u");
        map.put(710, "v");
        map.put(67, "w");
        map.put(78, "x");
        map.put(39, "y");
        map.put(710, "z");

        System.out.println(Arrays.stream(hashTable).collect(Collectors.toList()));

        String value = map.get(39);
        System.out.println(value);

        String value1 = map.get(19);
        System.out.println(value1);

        String value2 = map.get(17);
        System.out.println(value2);

        String value3 = map.get(67);
        System.out.println(value3);

    }

}
