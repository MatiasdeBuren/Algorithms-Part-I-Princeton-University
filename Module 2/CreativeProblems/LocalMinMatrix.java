package CreativeProblems;
import edu.princeton.cs.algs4.StdOut;

// Local minimum in a matrix. Given an n-by-n array a[] of n2 distinct integers, design an algorithm that runs in time proportional to n log n to find a local minimum: 
// an pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1], a[i][j] > a[i-1][j], and a[i][j] > a[i][j-1] 
// (assuming the neighboring entry is in bounds).

public class LocalMinMatrix {
    private int[][] a;
    private int n;

    public LocalMinMatrix(int[][] a){
        this.a = a;
        this.n = a.length;
    }

    // public int findLocalMin(){
    //     int lowC = 0;
    //     int highC = n - 1;
    //     int lowR = 0;
    //     int highR = n - 1;

    //     while (lowC <= highC && lowR <= highR){
    //         int midC = (lowC + highC) / 2;
    //         int midR = (lowR + highR) / 2;
    //         if (a[midR - 1][midC] < a[midR][midC] && a[midR][midC] < a[midR + 1][midC] && a[midR][midC - 1] < a[midR][midC] && a[midR][midC] < a[midR][midC + 1]){
    //             return a[midR][midC];
    //         }
    //         if (a[midR - 1][midC] > a[midR][midC]){
    //             highR = midR - 1;
    //         }
    //         if (a[midR + 1][midC] < a[midR][midC]){
    //             lowR = midR + 1;
    //         }
    //         if (a[midR][midC - 1] > a[midR][midC]){
    //             highC = midC - 1;
    //         }
    //         if (a[midR][midC + 1] < a[midR][midC]){
    //             lowC = midC + 1;
    //         }
    //     }
    //     return -1;
    // }

    public int findLocalMin(){
        int lowC = 0;
        int highC = n - 1;
        int lowR = 0;
        int highR = n - 1;

        while (lowC <= highC && lowR <= highR){
            int midC = (lowC + highC) / 2;
            int midR = (lowR + highR) / 2;
            int min = a[midR][midC];
            int minR = midR;
            int minC = midC;
            for (int i = 0; i < n; i++){
                if (a[i][midC] < min){
                    min = a[i][midC];
                    minR = i;
                    minC = midC;
                }
                if (a[midR][i] < min){
                    min = a[midR][i];
                    minR = midR;
                    minC = i;
                }
            }
            if (min == a[midR][midC]){
                return minR;
            }
            if (min == a[midR][midC]){
                return minC;
            }
            if (minR < midR){
                highR = midR - 1;
            }
            if (minR > midR){
                lowR = midR + 1;
            }
            if (minC < midC){
                highC = midC - 1;
            }
            if (minC > midC){
                lowC = midC + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] a = {{9, 8, 28, 14, 5}, 
                    {7, 1, 2, 1, 6}, 
                    {20, 10, 40, 30, 60}, 
                    {30, 70, 80, 90, 100}, 
                    {110, 120, 130, 140, 150}};
        LocalMinMatrix lmm = new LocalMinMatrix(a);
        int localMin = lmm.findLocalMin();
        StdOut.println("Local minimum index: " + localMin);
    }
}
