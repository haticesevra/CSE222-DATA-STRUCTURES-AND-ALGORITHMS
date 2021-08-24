import java.util.*;
import java.io.*;

public class MaxHeap<E extends Comparable  <E> >  implements Comparable<MaxHeap<E> >, Iterable<E> {
    private E[][] heap;
    public int heapSize=0;
    public E rootHeap;
    private int numOfElements=0;

    Comparator < E > comparator = null;

    @Override
    public int compareTo(MaxHeap<E> e){
        return 0;
    }

    public MaxHeap() {

    }
    public MaxHeap(MaxHeap m){
        this.copy((E[][]) m.heap);
        this.rootHeap = (E) m.rootHeap;
        this.heapSize = m.heapSize;
        this.numOfElements = m.numOfElements;
    }


    public MaxHeap(int cap, Comparator < E > comp) {
        if (cap < 1)
            throw new IllegalArgumentException();

        heap = (E[][]) new Object[cap + 1][2];
        comparator = comp;
    }
    public  int get_numOfElements(){     return numOfElements; }

    public E getRoot(){   return heap[0][0];    }


    public boolean isEmpty(){
        if(heapSize == 0)
            return true;
        return false;
    }

    public boolean isFull(){
        if(get_numOfElements() == 7)
            return true;
        return false;
    }

    private int leftChild(int position){     return (2 * position); }

    private int rightChild(int position){    return (2 * position) + 1; }

    private int parentIndex(int position){     return (position-1)/2;   }

    public int size(){  return heapSize;    }

    public int power(int base, int exponent){
        int result=1;
        while (exponent != 0){
            result *= base;
            --exponent;
        }
        return result;
    }

    public int depth(){
        int x=0, i=0;
        while(x<=heapSize){
            x = x + power(2,i);
            i++;
        }
        return i;
    }

    public boolean search(E element){
        E[][] temp;
        int x=0;
        for(int i=0; i<heapSize; i++){
            if(heap[i][0] == element){
                System.out.print("element to root:  "+element);
                int index = i;
                while(index!=0){
                    index = parentIndex(index);
                    temp = (E[][]) new Object[depth()][2];
                    temp[x][0] = heap[index][0];
                    x++;
                    System.out.print(" -> " + heap[index][0]);
                }
                System.out.println();
                return true;
            }
        }
        System.out.println(element + " is not an element of the heap.");
        return false;

    }

    public E bubbleSort(E[][] arr, int size, int index){
        int n = size;
        for (int i=0; i < n-1; i++)
            for (int j=0; j < n-i-1; j++)
                if (compare(arr[j][0], arr[j+1][0])<0){
                    E temp = arr[j][0];
                    arr[j][0] = arr[j+1][0];
                    arr[j+1][0] = temp;
                }
        System.out.println("buble");
        for(int i=0; i<size; i++)
            System.out.print(arr[i][0]+ " ");
        System.out.println();
        return arr[index-1][0];
    }

    /**Remove ith value of the heap**/
        public void removeWithIndex(int index){
        if(index-1 >= heapSize)
            throw new NoSuchElementException("");

        E[][] sorted = (E[][]) new Comparable[heapSize][2];
        for(int i=0; i<heapSize; i++)
            sorted[i][0] = heap[i][0];
        E value = bubbleSort(sorted, heapSize, index);
        System.out.println(index + "th largest element-> " + value);
        for(int i=0; i<heapSize; i++)
            if(value == heap[i][0])
                removeItem(heap[i][0]);
    }

 


    public void increaseOccurVal(E item){
        //for(int i=0; i<heapSize; i++)
        // if(item == heap[i])
    }


    public void insert(E newItem){
      // System.out.println("\ninsert maxheap");

        reallocate();
        numOfElements++;
        if(heapSize == 1){
            //numOfElements++;
            heap[0][0] = newItem;
            printHeap();
        }
        else{
            // System.out.println("\n1. else");
           // numOfElements++;
            rootHeap = heap[0][0];
            if(compare(newItem,rootHeap)==1){
                // System.out.println("\n2. if");
                heap[0][0] = newItem;
                newItem = rootHeap;
            }

            heap[heapSize-1][0] = newItem;
            rootHeap = heap[0][0];

            int newData = heapSize-1;
            int parent = parentIndex(newData);
          //  System.out.println("par-> " + parent + "  new-> " + newData);

            printHeap();

            while(rootHeap != newItem  && compare(heap[parent][0], heap[newData][0]) == -1){
                //System.out.println("while");
                E temp = heap[newData][0];
                heap[newData][0] = heap[parent][0];
                heap[parent][0] = temp;
                newData = parent;
                parent = parentIndex(newData);
                printHeap();
            }

        }


    }



    public void removeItem(E item){
        if (isEmpty()) {
            System.out.println("There is no element to remove");
        }
        int q=0;
        for(int i=0; i<heapSize; i++)
            if(item == heap[i][0]){
                q = i;
                break;
            }

        int current = q;
        E temp = heap[q][0];
        heap[q][0] = heap[heapSize-1][0];
        heap[heapSize-1][0] = temp;
        System.out.println("önce");
        printHeap();
        delete();
        printHeap();

        int left = leftChild(q)+1;
        int right = rightChild(q)+1;
        int child,stop=0, r=0, l=0;

        while(hasChildren(current)){
            System.out.println("reiç cur " + heap[current][0]);
            System.out.println("right-> " + heap[right][0]);

            if(compare(heap[current][0], heap[right][0])== -1 || compare(heap[current][0], heap[left][0])==-1 ){
                System.out.println("iç kısım");

                if(heap[right][0] == null)
                    r=1;
                if(heap[left][0] == null)
                    l=1;

                if(compare(heap[right][0], heap[left][0])==1 && r!=1){
                    System.out.println("if");
                    temp = heap[right][0];
                    heap[right][0] = heap[current][0];
                    heap[current][0]= temp;
                    current = right;
                    right=rightChild(current)+1;
                    left=leftChild(current)+1;
                    r=0;

                }
                else if(compare(heap[right][0], heap[left][0])==-1 && l!=1){
                    System.out.println("else");
                    temp = heap[left][0];
                    heap[left][0] = heap[current][0];
                    heap[current][0] = temp;
                    current = left;

                    right=rightChild(current)+1;
                    left=leftChild(current)+1;
                    l=0;
                }
                printHeap();
            }
            else{
                break;
            }
        }
    }


    public void reallocate(){
        E[][] temp = (E[][]) new Comparable[heapSize + 1][2];
        for(int i=0; i<heapSize; i++)
            temp[i][0] = heap[i][0];

        heap = (E[][]) new Comparable[heapSize + 1][2] ;
        heapSize++;
        for(int i=0; i<heapSize; i++)
            heap[i][0] = temp[i][0];
    }


    public void delete(){
        heap[heapSize-1][0] = null;
        heapSize--;
    }

    public boolean hasChildren(int index){
        if(rightChild(index+1)>heapSize && leftChild(index+1)>heapSize ){
            System.out.println("nolikk");
            return false;
        }
        return true;
    }

    public void printHeap(){
        for(int i=0; i<heapSize; i++)
            System.out.print(heap[i][0] + " ");
        System.out.println();
    }



    private int compare(E left, E right) {
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else {
            return ( (Comparable < E > ) left).compareTo(right);
        }
    }

    public void copy(E[][] arr){
        for(int i=0; i<7; i++)
            for(int j=0; j<2; j++)
                arr[i][j] = heap[i][j];

    }



    public Iterator < E > iterator() {
        return null;
    }

    public E peek() {
        return null;
    }
    public E poll() {
        return null;
    }


}
