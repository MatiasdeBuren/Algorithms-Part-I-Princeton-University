package CreativeProblems;
import edu.princeton.cs.algs4.ThreeSumFast;

// Problem: Given an array of integers, find all distinct triples that sum to zero.
//The result should sum numbers from the same type of array, not from different indices. Either the original array or the sorted array can be used.

public class ThreeSum {
    private int[] arr;
    private int n;
    private int[] orderedArr;
    private int counts;

    public void findThreeSum(){
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int low = 0;
                int high = n - 1;
                while(low<= high){
                    int mid = (low+high) / 2;
                    int res = orderedArr[i] + orderedArr[j] + orderedArr[mid];
                    if (res == 0 && mid > j){
                        System.out.println(orderedArr[i] + " " + orderedArr[j] + " " + orderedArr[mid]);
                        ++counts;
                        //low = high + 1;
                    }
                    if (res > 0){
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        t.arr = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        t.orderedArr = new int[]{-40, -20, -10, 0, 5, 10, 30, 40};
        t.n = 8;
        t.findThreeSum();
        System.out.println(t.counts);
        //System.out.println(ThreeSumFast.count(t.arr));
        ThreeSumFast.printAll(t.arr);
    }
}
