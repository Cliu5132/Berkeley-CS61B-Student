public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void reverse() {
        IntNode holder = first;
        if(holder!=null){
            first = new IntNode(holder.item, null);
            while(holder.next!=null){
                holder=holder.next;
                System.out.println(holder.item);
                addFirst(holder.item);
            }
        }
    }

    /** iterative reverse */
    public void reverse2() {
        IntNode prev = null;
        IntNode current = first;
        IntNode next = null;
        while(current.next!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        first = current;
    }

    public IntNode reverseRecursive(IntNode prev, IntNode current){
        if(current.next!=null){
            IntNode next = current.next;
            current.next = prev;
            return reverseRecursive(current, next);
        }else{
            current.next = prev;
            return current;
        }
    }

    /** recursive reverse */
    public void reverse3() {
        first = reverseRecursive(null, first);
    }

    public void insert(int x, int position){
        if(position==0){
            addFirst(x);
        }else{
            IntNode current = first;
            int i = 1;
            while(current!=null){
                if(i==position || current.next==null){
                    IntNode holder = new IntNode(x, current.next);
                    current.next = holder;
                    break;
                }
                current = current.next;
                i++;
            }
        }
    }

    /** recommended */
    public void insert2(int item, int position){
        if(first == null || position == 0){
            addFirst(item);
            return;
        }
        IntNode currentNode = first;
        while(position>1&&currentNode.next!=null){
            position--;
            currentNode = currentNode.next;
        }
        IntNode newNode = new IntNode(item, currentNode.next);
        currentNode.next=newNode;
    }
    public static void main(String[] args) {
//        SLList dummy = new SLList();
//        dummy.addFirst(2);
//        dummy.addFirst(6);
//        dummy.addFirst(5);
//        dummy.addFirst(1);
//        dummy.reverse3();
        int[] arr = {5, 2, 1};
//        int item = 6;
//        int position = 2;
//        insert(arr, item, position);
//        reverse(arr);
        int[] arr2 = replicate(arr);
    }

    /** Arrays */
    public static int[] insert(int[] arr, int item, int position) {
        int[] newArr = new int[arr.length+1];
        for(int i = 0; i < position; i++){
            newArr[i]=arr[i];
        }
        if(position>=arr.length){
            position=arr.length;
        }else{
            for(int i = arr.length - 1; i >= position; i--){
                newArr[i+1]= arr[i];
            }
        }
        newArr[position]=item;
        return arr;
    }

    public static void reverse(int[] arr) {
        for(int i=0; i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int[] newArr = new int[arr.length*2];
        int base = 0;
        for(int i=0;i<arr.length;i++){
            int times = arr[i];
            for(int j = 0; j<times;j++){
                if(i+j>= newArr.length/2){
                    int[] newNewArr = new int[newArr.length*2];
                    System.arraycopy(newArr, 0, newNewArr, 0, i+j);
                    newArr = newNewArr;
                }
                newArr[i+j+base]=times;
            }
            base += times-1;
        }
        return newArr;
    }
}