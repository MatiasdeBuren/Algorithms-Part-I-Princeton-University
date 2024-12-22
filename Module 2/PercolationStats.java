import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private double[] fractions;
    private double CONFIDENCE_95 = 1.96;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be greater than 0");
        }
        fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int openedSites = 0;
            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;  
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    openedSites++;
                }
            }
            fractions[i] = openedSites * 1.0 / (n * n);
        }
    }   

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(fractions.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(fractions.length));
    }

   // test client (see below)
   public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
   }
}