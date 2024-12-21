import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be greater than 0");
        }
        
    }

    // sample mean of percolation threshold
    public double mean(){
        
    }

    // sample standard deviation of percolation threshold
    public double stddev(){

    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){

    }

   // test client (see below)
   public static void main(String[] args){
    
   }

}