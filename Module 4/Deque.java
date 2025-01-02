import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }

        public Item next(){
            if (!hasNext()){
                throw new java.util.NoSuchElementException("No more items to return");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    // construct an empty deque
    public Deque(){
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if(isEmpty()){
            first = new Node();
            first.item = item;
            first.next = last;
            first.previous = null;
            last = first;
        }
        else{
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            first.previous = null;
            oldFirst.previous = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item){
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if(isEmpty()){
            last = new Node();
            last.item = item;
            last.next = null;
            last.previous = first;
            first = last;
        }
        else{
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            last.previous = oldLast;
            oldLast.next = last;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Deque is empty");
        }
        Item itemToRemove = first.item;
        first = first.next;
        //System.out.println("First item: " + first.item);
        if (first != null) {
            first.previous = null; // Disconnect the removed node
        } 
        else {
            last = null;
        }
        size--;
        return itemToRemove;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException("Deque is empty");
        }
        Item itemToRemove = last.item;
        last = last.previous; 

        if (last != null) {
            last.next = null; // Disconnect the removed node
        } 
        else {
            first = null;
        }
        size--;
        return itemToRemove;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println("After adding 3 items: ");
        for (Integer i : deque){
            System.out.println(i);
        }

        deque.removeFirst();
        System.out.println("After removing first item: ");
        for (Integer i : deque){
            System.out.println(i);
        }

        deque.addLast(4);
        System.out.println("After adding last item: ");
        for (Integer i : deque){
            System.out.println(i);
        }

        deque.removeLast();
        System.out.println("After removing last item: ");
        for (Integer i : deque){
            System.out.println(i);
        }
    }

}