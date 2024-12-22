import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean openSites[][];
    private int size;
    private int openSitesCount = 0;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backWachPrevention; //Wont have the bottom virtual site, used as a second union find to check if a site is full
     // test client (optional)
     public static void main(String[] args){
        // size = 5;
        // Percolation p = new Percolation(size);
        // //Ill add 2 to the size to account for the virtual top and bottom sites, which will be at n^2 and n^2 + 1
        // uf = new WeightedQuickUnionUF( (size * size) + 2);
        // p.open(1, 1);
        // p.open(2,1);
        // p.open(3,1);
        // p.open(4,1);
        // p.open(4,2);
        // p.open(5,2);
        // StdOut.println("Connected (1, 1) to top virtual site: " + (uf.find(0)==uf.find(25)));
        // StdOut.println("Connected (1, 1) to bottom virtual site: " + (uf.find(0)==uf.find(26)));
        // StdOut.println("Percolates: " + p.percolates());
    }
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        size = n;
        uf = new WeightedQuickUnionUF( (n * n) + 2);
        backWachPrevention = new WeightedQuickUnionUF( (n * n) + 1);
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        openSites = new boolean[n][n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("row and col must be between 1 and n");
        }
        if (!isOpen(row, col)) {
            openSites[row - 1][col - 1] = true;
            openSitesCount++;
            int sitesToConnect[][] = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
            for (int i = 0; i < 4; i++){
                int r = sitesToConnect[i][0];
                int c = sitesToConnect[i][1];
                if (r >= 1 && r <= size && c >= 1 && c <= size && isOpen(r, c)){
                    uf.union( (row - 1) * size + (col - 1), (r - 1) * size + (c - 1) );
                    backWachPrevention.union( (row - 1) * size + (col - 1), (r - 1) * size + (c - 1) );
                }
            }
            if (row == 1){
                uf.union( (row - 1) * size + (col - 1), size * size);
                backWachPrevention.union( (row - 1) * size + (col - 1), size * size);
            }
            if (row == size){
                 uf.union( (row - 1) * size + (col - 1), (size * size) + 1);
            }
        }
        
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("row and col must be between 1 and n");
        }
        return openSites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("row and col must be between 1 and n");
        }
        boolean backWashCondition = backWachPrevention.find((row - 1) * size + (col - 1)) == backWachPrevention.find(size*size);
        return ( uf.find((row - 1) * size + (col - 1)) == uf.find(size*size)  && backWashCondition);
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return openSitesCount;
    }

    // does the system percolate?
    public boolean percolates(){
        return uf.find(size*size) == uf.find((size*size) + 1);
    }
}