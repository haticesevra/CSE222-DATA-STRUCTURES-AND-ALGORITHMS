public class Driver {

    public Driver(){

    }

    public void testPart1(){
        Heap<Integer> heap = new Heap<>();


        System.out.println("\nINSERTION TEST");
        heap.insert(25); heap.printHeap();
        heap.insert(33); heap.printHeap();
        heap.insert(8);  heap.printHeap();
        heap.insert(75); heap.printHeap();
        heap.insert(45); heap.printHeap();
        heap.insert(11); heap.printHeap();
        heap.insert(1);  heap.printHeap();


        System.out.println("\nSEARCH ELEMENT TEST");
        heap.search(45);

        System.out.println("\nSEARCH ELEMENT TEST");
        heap.search(54);



        System.out.println("\nMERGE HEAPS TEST");
        Heap<Integer> other = new Heap<>();
        other.insert(55);
        other.insert(9);
        other.insert(22);
        other.insert(111);
        other.insert(2);
        other.insert(12);

        System.out.print("First heap-> "); heap.printHeap();
        System.out.print("Other heap-> "); other.printHeap();
        System.out.print("After merging-> ");
        heap.merge(other); heap.printHeap();

        System.out.println("\nREMOVE TH LARGEST TEST");
        heap.removeWithIndex(9);
        System.out.print("After removing -> "); heap.printHeap();

        System.out.println("\nSET LAST ELEMENT BY ITERATOR TEST");
        heap.setLast(77);
        System.out.print("After set -> "); heap.printHeap();
    }


    public void testPart2(){
        BSTHeapTree<Integer> test = new BSTHeapTree<>();
        test.add(55);
        test.add(44);
        test.add(1);
        test.add(66);
        test.add(33);
        test.add(11);

        test.add(5);
        test.add(2);
        test.add(111);
        test.add(3);
        test.add(20);

    }

}
