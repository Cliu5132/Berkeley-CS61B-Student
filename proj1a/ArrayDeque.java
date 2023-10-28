public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst=4;
        nextLast=5;
    }

    /** Resizes the underlying array to the target capacity. */
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    /** public void addFirst(T item) */
    public void addFirst(Item x) {

        items[nextFirst] = x;

        if(nextFirst==0){
            nextFirst = items.length-1;
        } else {
            nextFirst--;
        }

        size++;
    }

    /** public void addLast(T item) */
    public void addLast(Item x) {
        items[nextLast] = x;

        if (nextLast==items.length-1) {
            nextLast = 0;
        } else {
            nextLast++;
        }

        size++;
    }

    /** public boolean isEmpty() */

    /** public int size() */

    /** public void printDeque() */

    /** public T removeFirst() */

    /** public T removeLast() */

    /** public T get(int index) */

}