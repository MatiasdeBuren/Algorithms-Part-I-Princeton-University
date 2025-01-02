import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node next; //el de atras
        private Node previous; //el de adelante
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
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

    // construct an empty randomized queue
    public RandomizedQueue(){
        first = null;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return first == null;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldLast;
        if(isEmpty()){
            first = last;
        }
        else{
            oldLast.next = last;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int randomIndex = StdRandom.uniformInt(size);
        Node current = first;
        for (int i = 0; i != randomIndex; i++) {
            current = current.next;
        }
        Item itemToRemove = current.item;
        if (current == first) {
            first = first.next;
            if (first != null) {
                first.previous = null;
            }
        } else if (current == last) {
            last = last.previous;
            last.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        if (isEmpty()){
            last = null;
        }
        size--;
        return itemToRemove;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int randomIndex = StdRandom.uniformInt(size);
        Node current = first;
        for (int i = 0; i != randomIndex; i++) {
            current = current.next;
        }
        return current.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        rq.enqueue(7);
        rq.enqueue(8);
        rq.enqueue(9);
        rq.enqueue(10);
        rq.enqueue(11);
        rq.enqueue(12);
        System.out.println("After adding more items: ");
        for (Integer i : rq){
            System.out.println(i);
        }
        System.out.println("Dequeue: " + rq.dequeue());
        for (Integer i : rq){
            System.out.println(i);
        }
        System.out.println("Dequeue: " + rq.dequeue());
        for (Integer i : rq){
            System.out.println(i);
        }
        System.out.println("Dequeue: " + rq.dequeue());
        for (Integer i : rq){
            System.out.println(i);
        }
    }

}