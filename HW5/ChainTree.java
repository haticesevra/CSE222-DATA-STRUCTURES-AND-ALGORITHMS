import java.util.*;

public class ChainTree < K extends Comparable<K>, V > implements KWHashMap < K, V > {

    private TreeSet < Entry < K, V >> [] table;
    private int numKeys;
    private static final int CAPACITY = 2000;
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry < K extends Comparable<K>, V > implements Comparable<Entry<K,V>> {
        private K key;
        private V value;

        @Override
        public int compareTo(Entry<K,V> e){
            return key.compareTo(e.key);
        }

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

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }

    // Constructor
    public ChainTree() {
        table = new TreeSet[CAPACITY];
    }

    public V get(Object key) {
        int index = key.hashCode() % 10;
        if (index < 0)
            index += 10;
        if (table[index] == null)
            return null; // key is not in the table.

        // Search the list at table[index] to find the key.
        for (Entry < K, V > nextItem : table[index]) {
            System.out.print( nextItem.key + " - ");
            if (nextItem.key.equals(key))
                return nextItem.value;
        }

        // assert: key is not in the table.
        return null;
    }

    public V put(K key, V value) {
        int index = key.hashCode() % 10;
        if (index < 0)
            index += 10;
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new TreeSet < Entry < K, V >> ();
        }

        // Search the list at table[index] to find the key.
        for (Entry < K, V > nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }


        // assert: key is not in the table, add new item.
        table[index].add(new Entry < K, V > (key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * 10))
            rehash();
        return null;
    }

    /** Returns the number of entries in the map */
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }


    public V remove(Object key) {
        int index = key.hashCode() %10;
        if (index < 0)
            index += 10;
        if (table[index] == null)
            return null; // Key not in table
        Iterator < Entry < K, V >> iter = table[index].iterator();
        while (iter.hasNext()) {
            Entry < K, V > nextItem = iter.next();
            // If the search is successful, return the value.
            if (nextItem.key.equals(key)) {
                V returnValue = nextItem.value;
                iter.remove();
                return returnValue;
            }
        }
        return null; // Key not in table
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: the size of table is doubled and is an
     odd integer. Each non-deleted entry from the original
     table is reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    public void rehash() {
        // Save a reference to oldTable
        TreeSet < Entry < K, V >> [] oldTable = table;
        // Double capacity of this table
        table = new TreeSet[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for (Entry < K, V > nextEntry : oldTable[i]) {
                    // Insert entry in expanded table
                    put(nextEntry.key, nextEntry.value);
                }
            }
        }
    }

}



