package CreativeProblems;

// Second smallest. Give an algorithm to find the smallest and second smallest elements from a list of N items using the minimum number of comparisons. 
// Answer: you can do it in ceil(N + lg(N) - 2) comparisons by building a tournament tree where each parent is the minimum of its two children. 
// The minimum ends up at the root; the second minimum is on the path from the root to the minimum.

public class SecondSmallest {
    private int[] arr;
    private int N;

    public SecondSmallest(int[] arr) {
        this.arr = arr;
        this.N = arr.length;
    }

    public int[] findSmallest() {
        int[] result = new int[2];
        
        return result;
    }
}
