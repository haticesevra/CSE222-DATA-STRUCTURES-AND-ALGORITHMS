import java.io.*;

public class BinarySearchTree < E
        extends Comparable < E >>
{
    MaxHeap<E> temp;
    protected boolean addReturn;

    protected E deleteReturn;
    public Node < E > root;
    public Node < E > rootConst;

    public static class Node < E  extends Comparable < E >> extends MaxHeap<E> implements Serializable {
        protected E data;

        protected Node < E > left;

        protected Node < E > right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return data.toString();
        }
    }


    public E find(E target) {
        return find(root, target);
    }

    private E find(Node < E > localRoot, E target) {
        if (localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }


    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }


    private Node < E > add(Node <E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node < E > (item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) > 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }


    public E delete(E target) {
        root = delete(root, target);

        return deleteReturn;
    }

    private Node < E > delete(Node < E > localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult > 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult < 0) {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else {
            deleteReturn = localRoot.data;
            if (localRoot.left == null) 
                return localRoot.right;
            else if (localRoot.right == null) 
                return localRoot.left;
            else {
                if (localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
        }}}
    }


    public boolean remove(E target) {
        return delete(target) != null;
    }


    public boolean contains(E target) {
        return find(target) != null;
    }


    private E findLargestChild(Node < E > parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }

    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }


}
