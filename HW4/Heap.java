import java.util.*;

public class Heap<E extends Comparable  <E> >  implements Iterable<E> {
    private E[] heap;
    private E rootHeap;
    private int heapSize=0;
    private int numOfElements=0;
    Comparator < E > comparator = null;

    /**No parameter constructor**/
    public Heap() { /*   INTENTIONALLY EMPTY     */    }

    /**Two parameter constructor**/
    public Heap(int cap, Comparator < E > comp) {
        if (cap < 1)
            throw new IllegalArgumentException();
        heap = (E[]) new Object[cap + 1];
        comparator = comp;
    }

    /**Returns number of elements in the heap**/
    public  int get_numOfElements(){
        return numOfElements;
    }

    /**Returns root of the heap**/
    public E getRoot(){
        return heap[0];
    }

    /**Returns true is heap is empty otherwise returns false**/
    public boolean isEmpty(){
        if(heapSize == 0)
            return true;
        return false;
    }

    /**Returns index of left child of given position**/
    private int leftChild(int position){    return (2 * position);      }

    /**Returns index of right child of given position**/
    private int rightChild(int position){    return (2 * position) + 1;    }

    /**Returns index of left child of given position**/
    private int parentIndex(int position){  return (position-1)/2;      }

    /**Returns size of the heap**/
    public int size(){      return heapSize;    }

    /**Returns depth of the heap**/
    public int depth(){
        int x=0, i=0;
        while(x<=heapSize){
            x = x + power(2,i);
            i++;
        }
        return i;
    }

    /**Inserts new element to the heap**/
    public void insert(E newItem){
        E tmp = newItem;
        reallocate();
        numOfElements++;
        if(heapSize == 1)
            heap[0] = newItem;
        else{
            rootHeap = heap[0];
            if(compare(newItem,rootHeap)==-1){
                heap[0] = newItem;
                newItem = rootHeap;
            }
            heap[heapSize-1] = newItem;
            rootHeap = heap[0];
            int newData = heapSize-1;
            int parent = parentIndex(newData);

            while(rootHeap != newItem  && compare(heap[parent], heap[newData]) == 1){
                E temp = heap[newData];
                heap[newData] = heap[parent];
                heap[parent] = temp;
                newData = parent;
                parent = parentIndex(newData);
            }}
    }

    /**Search for an element in the heap, prints the path**/
    public boolean search(E element){
        for(int i=0; i<heapSize; i++){
            if(heap[i] == element){
                System.out.println(element + " is an element of the heap. The path to find the element is below ");
                System.out.print("from element to root:  "+element);
                int index = i;
                while(index!=0){
                    index = parentIndex(index);
                    System.out.print(" -> " + heap[index]);
                }
                System.out.println();
                return true;
            }}
        System.out.println(element + " is not an element of the heap.");
        return false;
    }

    /**Remove ith value of the heap**/
        public void removeWithIndex(int index){
        if(index-1 >= heapSize)
            throw new NoSuchElementException("");

        E[] sorted = (E[]) new Comparable[heapSize];
        for(int i=0; i<heapSize; i++)
            sorted[i] = heap[i];

        E value = bubbleSort(sorted, heapSize, index);
        System.out.println(index + "th largest element-> " + value);
        for(int i=0; i<heapSize; i++)
            if(value == heap[i])
                removeItem(heap[i]);
    }

    /**Removes the given item and resorts the heap**/
    public void removeItem(E item){
        if (isEmpty())
            System.out.println("There is no element to remove");
        int q=0;
        for(int i=0; i<heapSize; i++)
            if(item == heap[i]){
                q = i; break;
            }
        int current = q;
        E temp = heap[q];
        heap[q] = heap[heapSize-1];
        heap[heapSize-1] = temp;
        delete();

        int left = leftChild(q)+1;
        int right = rightChild(q)+1;
        int r=0, l=0;
        while(hasChildren(current)){
            if(compare(heap[current], heap[right])== 1 || compare(heap[current], heap[left])==1 ){
                if(heap[right] == null) r=1;
                if(heap[left] == null)  l=1;
                if(compare(heap[right], heap[left])==-1 && r!=1){
                    temp = heap[right];
                    heap[right] = heap[current];
                    heap[current]= temp;
                    current = right;
                    right=rightChild(current)+1;
                    left=leftChild(current)+1;
                    r=0;
                }
                else if(compare(heap[right], heap[left])==-1 && l!=1){
                    temp = heap[left];
                    heap[left] = heap[current];
                    heap[current] = temp;
                    current = left;
                    right=rightChild(current)+1;
                    left=leftChild(current)+1;
                    l=0;
                }}
            else break;
        }
    }


    /**Sorts the heap from largest to smallest**/
    private E bubbleSort(E[] array, int size, int index){
        for(int i = array.length; i > 1; i--)
            for(int j = 0; j < i - 1; j++)
                if(array[j].compareTo(array[j+1]) < 0)
                    swapElements(j, array);
        System.out.print("sorted (largest to smallest)-> ");
        for(int i=0; i<size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        return array[index-1];
    }

    /**Swap positions of given elements**/
    private void swapElements(int index, E[] arr){
        E temp = arr[index];
        arr[index] = arr[index+1];
        arr[index+1] = temp;
    }


    /**Reallocates the heap**/
    public void reallocate(){
        E[] temp = (E[]) new Comparable[heapSize + 1];
        for(int i=0; i<heapSize; i++)
            temp[i] = heap[i];

        heap = (E[]) new Comparable[heapSize + 1] ;
        heapSize++;
        for(int i=0; i<heapSize; i++)
            heap[i] = temp[i];
    }


    /**Deletes last element**/
    public void delete(){
        heap[heapSize-1] = null;
        heapSize--;
    }

    /**Returns true if node in the given index has children otherwise return false**/
    public boolean hasChildren(int index){
        if(rightChild(index+1)>heapSize || leftChild(index+1)>heapSize )
            return false;
        return true;
    }

    /**Compares given items**/
    private int compare(E left, E right) {
        if (comparator != null)
            return comparator.compare(left, right);
        else
            return ( (Comparable < E > ) left).compareTo(right);
    }

    /**Merges two heaps by using insert function**/
    public void merge(Heap other){
        for(int i=0; i<other.heapSize; i++)
            insert((E) other.heap[i]);
    }


    /**Creates iterator object**/
    public Iterator < E > iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int pos = 0;

        /**If node has next return true, otherwise returns false**/
        @Override
        public boolean hasNext() {
            if (pos < heapSize)  return true;
            else return false;
        }

        /**If node has next iterates iterator to next node**/
        @Override
        public E next() {
            if (this.hasNext())     return heap[pos++];
            else    return null;
        }
    }


    /**Iterator visits all cells, find last element and sets it with given parameter**/
    public E setLast(E item){
        Iterator<E> iterator = iterator();
        E nextValue = null;
        System.out.print("Iterator visits - ");

        while (iterator.hasNext()) {
            nextValue = iterator.next();
            System.out.print( nextValue + " -> ");
        }
        System.out.println("\nto be set " + nextValue);
        removeItem(nextValue);
        insert(item);
        return nextValue;
    }

    public E peek() {
        return null;
    }

    public E poll() {
        return null;
    }


    public int power(int base, int exponent){
        int result=1;
        while (exponent != 0){
            result *= base;
            --exponent;
        }
        return result;
    }


    /**Prints heap**/
    public void printHeap(){
        for(int i=0; i<heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }




}
