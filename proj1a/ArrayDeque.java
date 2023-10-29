/** public class ArrayDeque */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Creates an empty list.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * Resizes the underlying array to the target capacity.
     */
    private void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];

        int copyPointer = nextFirst;

        for (int i = 0; i < size; i++) {
            if (copyPointer == items.length - 1) {
                copyPointer = 0;
            } else {
                copyPointer++;
            }
            a[i] = items[copyPointer];
        }

        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /**
     * public void addFirst(T item)
     */
    public void addFirst(T x) {
        if (size == items.length - 1) {
            resize(2 * items.length);
        }

        items[nextFirst] = x;

        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }

        size++;
    }

    /**
     * public void addLast(T item)
     */
    public void addLast(T x) {
        if (size == items.length - 1) {
            resize(2 * items.length);
        }

        items[nextLast] = x;

        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }

        size++;
    }

    /**
     * public boolean isEmpty()
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * public int size()
     */
    public int size() {

        return size;

    }

    /**
     * public void printDeque()
     */
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        int printPointer = nextFirst;

        while (printPointer != nextLast - 1) {

            if (printPointer + 1 > items.length - 1) {
                printPointer = 0;
            } else {
                printPointer = printPointer + 1;
            }

            System.out.print(items[printPointer] + " ");

        }

        System.out.println();
    }

    /**
     * public T removeFirst()
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        if (items.length > 8 && size <= items.length * 0.25) {
            resize(items.length / 2);
        }

        int removedPointer = nextFirst;

        if (removedPointer == items.length - 1) {
            removedPointer = 0;
        } else {
            removedPointer++;
        }

        T y = items[removedPointer];

        items[removedPointer] = null;

        nextFirst = removedPointer;

        size--;

        return y;
    }

    /**
     * public T removeLast()
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        if (items.length > 8 && size <= items.length * 0.25) {
            resize(items.length / 2);
        }

        int removedPointer = nextLast;

        if (removedPointer == 0) {

            removedPointer = items.length - 1;

        } else {

            removedPointer--;
        }

        T y = items[removedPointer];

        items[removedPointer] = null;

        nextLast = removedPointer;

        size--;

        return y;

    }

    /**
     * public T get(int index)
     */
    public T get(int index) {

        if (index >= size) {
            return null;
        }

        int getPointer = nextFirst + index + 1;

        if (getPointer > items.length - 1) {
            getPointer -= items.length;
        }

        T y = items[getPointer];

        return y;
    }

}
