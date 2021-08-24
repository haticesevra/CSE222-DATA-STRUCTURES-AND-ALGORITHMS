
    public class Coalesced<K,V>{
        HashTableOpen<K,V> open ;

        public Coalesced(){
            open =  new HashTableOpen<>();
        }

        public void add(K key, V value){
            open.put(key, value);
        }

        public void print(){
            open.print();
        }

        public void remove(K key){
            open.remove(key);
        }

        public void get(K key){
            open.find(key);
        }

    }