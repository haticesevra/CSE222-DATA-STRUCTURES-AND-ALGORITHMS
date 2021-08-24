/** Hash table implementation using open addressing.
 *  @author Koffman and Wolfgang
 */

public class HashTableOpen < K, V >
        implements KWHashMap < K, V > {
    // Data Fields
    private Entry < K, V > [] table;
    private static final int START_CAPACITY = 10;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private int nextFlag=0;
    private final Entry < K, V > DELETED =
            new Entry < K, V > (null, null);
    private K[] arr;

    // Constructor
    public HashTableOpen() {
        table = new Entry[START_CAPACITY];
        arr = (K[]) new Object[10];
    }



    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {

        /** The key */
        private K key;

        /** The value */
        private V value;

        public int next=-1;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        public boolean isIn() {
            return true;
        }

    }




    public void print(){
        for(int i=0; i< table.length; i++){
            if(table[i] != null){
            System.out.print( i+"-\tkey->\t" + table[i].getKey());
                if(table[i].next != -1 )
                    System.out.println("\tnext->\t" + table[i].next);
                else
                    System.out.println("\tnext-> null");
            }
            else
                System.out.println( i+"-\tnull\t\tnext-> null");
        }
    }

    /** Returns the number of entries in the map */
    public int size() {
        return numKeys;
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /** Finds either the target key or the first empty slot in the
     search chain using linear probing.
     pre: The table is not full.
     @param key The key of the target object
     @return The position of the target or the first empty slot if
     the target is not in the table.
     */
    public int find(Object key) {
        // Calculate the starting index.
        int index = key.hashCode() % 10;
        if (index < 0)
            index += table.length; // Make it positive.

        // Increment index until an empty slot is reached
        // or the key is found.
        while ( (table[index] != null)
                && (!key.equals(table[index].key))) {
            index = quadraticProbe(index, key);

            // Check for wraparound.
            if (index >= table.length)
                index = 0; // Wrap around.
        }
        return index;
    }

    private int quadraticProbe(int index, Object key)
    {
        boolean found = false;
        int removedStateIndex = -1; // index of first location in
        // removed state
        int i=0;
        while ( !found && (table[index] != null) && i< 10)
        {

            if (table[index].isIn())
            {
                if (key.equals(table[index].getKey()))
                    found = true; // key found
                else // follow probe sequence
                {
                    //System.out.println("pooo");
                    nextFlag=1;
                    index = (index + i*i) % 10;         // linear probing
                    i++;
                }
            }
            else // skip entries that were removed
            {
                // save index of first location in removed state
                if (removedStateIndex == -1)
                    removedStateIndex = index;

                index = (index + i*i) % 10;         // linear probing
                i++ ;
            } // end if
        } // end while
        // Assertion: either key or null is found at hashTable[index]


        if (found || (removedStateIndex == -1) )
            return index;             // index of either key or null
        else
            return removedStateIndex; // index of an available location
    } // end probe


    /** Method get for class HashtableOpen.
     @param key The key being sought
     @return the value associated with this key if found;
     otherwise, null
     */
    public V get(Object key) {
        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);

        // If the search is successful, return the value.
        if (table[index] != null)
            return table[index].value;
        else
            return null; // key not found.
    }

    /** Method put for class HashtableOpen.
     post: This key-value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed. If the LOAD_THRESHOLD
     is exceeded, the table is expanded.
     @param key The key of item being inserted
     @param value The value for this key
     @return Old value associated with this key if found;
     otherwise, null
     */
    public V put(K key, V value) {
        int addIndex=0;
        nextFlag=0;

        int addNext = key.hashCode() % 10;
            if (addNext < 0)
                addNext += 10;


        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);

        for(int i=0; i<10; i++){
            //System.out.print(" ~ " + arr[i]);
        }


        arr[addIndex] = key;

        if(nextFlag == 1){
            int z=0;
            if(table[addNext].next == -1){
                table[addNext].next = index;
                z=1;
            }
            else {
                table[table[addNext].next].next = index;
            }

          //  addNext= findIndex(arr[addNext]);

            //table[addNext].next = index;

        }
        // If an empty element was found, insert new entry.
        if (table[index] == null) {
            table[index] = new Entry < K, V > (key, value);
            numKeys++;
            // Check whether rehash is needed.
            double loadFactor =
                    (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }


        // assert: table element that contains the key was found.
        // Replace value for this key.
        V oldVal = table[index].value;
        table[index].value = value;
        return oldVal;
    }

    public int findIndex(K data){
        for(int i=0; i< table.length; i++) {
            if (table[i] != null) {
              //  System.out.println("yyy  " + table[i].getKey() );
                if (data == table[i].getKey())
                    return i;
            }
        }
        return -1;
    }
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: The size of table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        //System.out.println("rehas");
        // Save a reference to oldTable.
        Entry < K, V > [] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    /**** BEGIN EXERCISE ****/
    /** Remove the item with a given key value
     *  @param key The key to be removed
     *  @return The value associated with this key, or null
     *  if the key is not in the table.
     */
    public V remove(Object key) {
        int index = find(key);
        if (table[index] == null)
            return null;
        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        return oldValue;
    }

    /**** END EXERCISE ****/
}
