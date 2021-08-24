
public class NavigableSetWithSkipList<E extends Comparable<E>>  extends SkipList<E> implements NavigableSet<E>{
    SkipList<E> skipList;

    public int getSize(){
        return skipList.getSize();
    }


    public NavigableSetWithSkipList(){
        skipList = new SkipList<>();
    }

    @Override
    public void insert(E item){
        skipList.add(item);
    }

    @Override
    public void delete(E item){
        skipList.remove(item);
    }

    @Override
    public void descendingIterator(){
        skipList.iterator();
    }

    @Override
    public void tailSet(E toElement) {

    }

    @Override
    public void headSet(E fromElement) {

    }

    public void printSkipList() {
        System.out.println(skipList.toString());
    }
}
