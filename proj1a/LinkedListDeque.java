public class LinkedListDeque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        private StuffNode(StuffNode n1, T i, StuffNode n2) {
            prev = n1;
            item = i;
            next = n2;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {

        T a = null;

        sentinel = new StuffNode(null, a, null);

        sentinel.next = sentinel;

        sentinel.prev = sentinel;

        size = 0;

    }

    /**
     * public void addFirst(T item): Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {

        StuffNode first = new StuffNode(sentinel, item, sentinel.next);

        sentinel.next.prev = first;

        sentinel.next = first;

        size++;

    }

    /**
     * public void addLast(T item): Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {

        StuffNode last = new StuffNode(sentinel.prev, item, sentinel);

        sentinel.prev.next = last;

        sentinel.prev = last;

        size++;

    }

    /**
     * public boolean isEmpty(): Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * public int size(): Returns the number of items in the deque.
     */
    public int size() {

        return size;

    }

    /**
     * public void printDeque(): Prints the items in the deque
     * from first to last, separated by a space.
     */
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("LinkedListDeque is empty.");
            return;
        }

        StuffNode p = sentinel;

        while (true) {
            p = p.next;
            System.out.print(p.item + " ");

            if (p.next == sentinel) {
                System.out.println();
                return;
            }
        }
    }

    /**
     * public T removeFirst(): Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        StuffNode first = sentinel.next;

        StuffNode newFirst = sentinel.next.next;

        newFirst.prev = sentinel;

        sentinel.next = newFirst;

        size--;

        return first.item;

    }

    /**
     * public T removeLast(): Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        StuffNode last = sentinel.prev;

        StuffNode newLast = sentinel.prev.prev;

        sentinel.prev = newLast;

        newLast.next = sentinel;

        size--;

        return last.item;

    }

    /**
     * public T get(int index): Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists, returns null.
     */
    public T get(int index) {

        if (isEmpty()) {

            return null;

        }

        StuffNode p = sentinel;

        for (int i = 0; i <= index; i++) {

            p = p.next;

            if (i == index) {

                return p.item;

            }

        }

        return null;
    }

    /** getRecursive helper */
    private T recursiveHelper(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        }

        StuffNode nextPointer = p.next;
        index--;

        return recursiveHelper(nextPointer, index);
    }

    /**
     * public T getRecursive(int index)
     */
    public T getRecursive(int index) {

        if (isEmpty()) {

            return null;

        }

        StuffNode countDownPointer = sentinel.next;

        return recursiveHelper(countDownPointer, index);

    }

}
