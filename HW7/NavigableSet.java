public interface NavigableSet<E> {

    public void insert(E item);

    public void delete(E item);

    public void descendingIterator();

    public void iterator();

    public void tailSet(E toElement);

    public void headSet(E fromElement);

}
