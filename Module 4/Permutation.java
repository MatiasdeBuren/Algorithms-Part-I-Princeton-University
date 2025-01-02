import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    //Write a client program Permutation.java that takes an integer k as a command-line argument; reads a sequence of strings from standard input using StdIn.readString(); and prints 
    //exactly k of them, uniformly at random. Print each item from the sequence at most once.

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        String input = StdIn.readString();
        while (!input.equals("exit") && !StdIn.isEmpty()) {
            rq.enqueue(input);
            input = StdIn.readString();
        }
        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }
    }
}
