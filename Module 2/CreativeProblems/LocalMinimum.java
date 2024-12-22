package CreativeProblems;
import edu.princeton.cs.algs4.StdOut;

// Local minimum in an array. Write a program that, given an array a[] of n distinct integers, finds a local minimum: an index i such that both a[i] < a[i-1] and
//  a[i] < a[i+1] (assuming the neighboring entry is in bounds). Your program should use ~ 2 lg n compares in the worst case.

public class LocalMinimum {
    private int[] a;
    private int n;

    public LocalMinimum(int[] a){
        this.a = a;
        this.n = a.length;
    }

    public int findLocalMinimum(){
        int low = 0;
        int high = n - 1;
        while (low <=high){
            int mid = (low + high) / 2;
            StdOut.println("Mid: " + a[mid]);
            if (a[mid - 1] < a[mid] && a[mid + 1] > a[mid]){
                return mid;
            }
            if (a[mid - 1] > a[mid]){
                high = mid - 1;
                StdOut.println("High: " + a[high]);
            }
            else{
                low = mid + 1;
                StdOut.println("Low: " + a[low]);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = {9, 8, 28, 14, 5, 7, 1, 2, 1, 6, 20 , 10, 40, 50, 60};
        LocalMinimum lm = new LocalMinimum(a);
        StdOut.println("Local minimum index: " + lm.findLocalMinimum());
    }
}
