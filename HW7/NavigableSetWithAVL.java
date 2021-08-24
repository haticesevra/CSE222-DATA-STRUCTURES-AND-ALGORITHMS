
public class NavigableSetWithAVL<E extends Comparable<E>>  implements NavigableSet<E>{

    private AVLTree<E> avl;

    public NavigableSetWithAVL(){
        avl = new AVLTree<E>();
    }

    @Override
    public void insert(E item){
        avl.add(item);
    }

    @Override
    public void descendingIterator() {

    }

    @Override
    public void iterator(){
        avl.iterateTree(avl.getRoot(),1);
    }

    @Override
    public void headSet(E toElement){

        avl.inOrderHeadSet(avl.getRoot(), toElement);

    }

    @Override
    public void tailSet(E fromElement){
         avl.inOrderTailSet(avl.getRoot(), fromElement);


    }

    public void print(){
        System.out.println(avl.toString());
    }



    public void delete(E item){

    }

}
