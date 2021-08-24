public class BSTHeapTree<E extends Comparable<E>>{
    BinarySearchTree<MaxHeap<E>> bst;
    BinarySearchTree<E> allroots;

    private int HEAP_NUM = 7;
    private int x=0;
    private int counter=0;
    private int numOfNodesBST = 0;
    private int stop=0;
    private E before;


    public BSTHeapTree(){
        bst = new BinarySearchTree<MaxHeap<E>>();
        allroots = new BinarySearchTree<E>();
    }



    /*returns the number of occurrences of the item after insertion*/
    public int add(E item){
        addx(bst.root, item);
        return 1;
    }


    private int addx(BinarySearchTree.Node<MaxHeap<E>> localRoot, E item) {
        if (localRoot == null) {
            stop=0;
            numOfNodesBST++;
            System.out.println("\nNumber Of Nodes in BSTHeapTree ->    " + numOfNodesBST);
            MaxHeap<E> hp = new MaxHeap<E>();
            hp.insert(item);
            bst.add(hp);
            counter++;
            return 1;
        }
        else if (localRoot.data.size() < HEAP_NUM) {
            if(stop==0)
                allroots.add(localRoot.data.getRoot());
            else{
                allroots.delete(before);
                allroots.add(localRoot.data.getRoot());
            }
            before = localRoot.data.getRoot();
            localRoot.data.insert(item);
            System.out.print("\t\tNodes of BST -> ");
            allroots.inOrder();
            System.out.println();
            counter++;
            stop=1;
            return 1;
        }

        else {
            if(x==0) {
                counter=0;
                x=1;
                bst.root=localRoot.left;
                addx(bst.root, item);
            }
            else{
                counter=0;
                x=0;
                bst.root = localRoot.right;
                addx(bst.root, item);
            }
            return 4;
        }
    }


    /*returns the number of occurrences of the item after removal*/
    public int remove(int item){

        return 1;
    }

    /*returns the number of occurrences of the item in the BSTHeapTree*/
    public int find(int item){

        return 1;
    }


    public int find_mode(int item){

        return 1;
    }

    public void prt(){
        bst.toString();


    }


}