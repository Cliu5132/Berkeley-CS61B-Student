public class ArrayDequeTest {
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        ArrayDeque x = new ArrayDeque();

        x.addLast("a");
        x.addLast("b");
        x.addFirst("c");
        x.addLast("d");
        x.addLast("e");
        x.addLast("f");
        x.addFirst("g");
        x.addLast("h");
        x.addFirst("i");

        x.removeFirst();
        x.removeFirst();
        x.removeFirst();
        x.removeFirst();
        x.removeFirst();
        x.removeFirst();

        System.out.println(x.size());
        x.printDeque();
//
//        System.out.println(x.get(6));
//        System.out.println(x.get(0));
//        System.out.println(x.get(1));
//        System.out.println(x.get(2));
    }
}
