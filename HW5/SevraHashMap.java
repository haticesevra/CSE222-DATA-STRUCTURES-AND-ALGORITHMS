import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class SevraHashMap<K,V> extends HashMap<K,V> {
    private  int size=0;
    private  int iterCounter=0;
    private SevraHashMap<K,V> c;

    public SevraHashMap(){
    }

    public void iterator(K key){
        iterCounter=0;
        for(K i: keySet()){
            iterCounter++;
            if(i == key)
                break;
        }
        this.MapIterator(key);

    }

    public void findPrev(K key){
        iterCounter=0;
        int f=0;
        for(K i: keySet()) {
            iterCounter++;
            if (i == key){
                f=1;
                break;
            }
            else
                f=0;
        }
        if(f==0) {
            System.out.println(key + " is not an element of the map.");
        }
        else{
            MapIterator<K,V> p = new MapIterator<>(key,1);
            System.out.println("Previous of " + key + " is " + p.prev());
        }

    }

    public int size(){return size;}

    public void add(K key, V value){
        size++;
        put(key, value);
    }

    public Set<K> get_keySet(){
        return keySet();
    }

    public SevraHashMap getOuter() {
        return this;
    }

    public class MapIterator<K,V> implements Iterator<K>{
        private K key;
        private int localCount=0;
        SevraHashMap<K,V> copy;


        public MapIterator(){
            System.out.println("(used zero parameter constructor)");
            copy = getOuter();
            this.key = first();
            localCount=1;
            System.out.print(this.key + " - ");
            while(hasNext()){
                this.key = this.next();
                System.out.print(this.key + " - ");
                localCount++;
            }
        }

        public MapIterator(K key){
            System.out.println("(used 1 parameter constructor)   ");
           this.key = key;
           copy = getOuter();
           localCount=iterCounter;

                System.out.print(this.key + " - ");
                while(hasNext()){
                    this.key = this.next();
                    System.out.print(this.key + " - ");
                    localCount++;
                }

                if(iterCounter!=1){
                    localCount=size-iterCounter+1;
                    this.key = first();
                    while(hasNext()){
                        System.out.print(this.key + " - ");
                        this.key = this.next();
                        localCount++;
                    }
                }



        }

        public MapIterator(K key, int ignore2){
            copy = getOuter();
            this.key = key;
            localCount=iterCounter;
        }

        public K first(){
            K f=null;
            for(K i : copy.keySet()){
                f=i;
                break;
            }
              return f;
        }

        @Override
        public boolean hasNext(){
            if(localCount<size)
                return true;
            return false;
        }

        public boolean hasPrev(){
            if(localCount == 1)
                return false;
            return true;
        }

        @Override
        public K next(){
            int f=0;
            if (hasNext()) {
                for (K i : copy.keySet()) {
                    if(f==1)
                        return i;
                    if(key == i){
                      //  System.out.println("yoksa???");
                        f=1;
                    }}}
           K ret=null;
                for (K i : copy.keySet()){
                   ret=i;
                   break;
                }
            return ret;
        }

        public K prev(){
            K prevKey=null;
            int c=1;
            if(hasPrev()){
               for(K i: copy.keySet()){
                   c++;
                   if(c==iterCounter){
                       prevKey=i;
                       break;
                   }}
                //System.out.println("Prev of " + this.key + " is " + prevKey );
               return prevKey;
            }
            else {
                K ret = null;
                for (K i : copy.keySet())
                    ret = i;
               // System.out.println("Prev of " + this.key + " is " + ret );
                return ret;
            }}
    }

    public MapIterator<K,V> MapIterator(){
        return new MapIterator<K,V>();
    }

    public MapIterator<K,V> MapIterator(K key){
        int par=0;
        for (K i : this.keySet()) {
            if(i == key){
                par=1;
                break;
            }
        }
        if(par==0){
            System.out.println("!! " + key + " is not the key of this map !!");
            return new MapIterator<K,V>();
        }
        else {
            return new MapIterator<K, V>(key);
        }
    }

}
