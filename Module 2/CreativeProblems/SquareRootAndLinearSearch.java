package CreativeProblems;

// Throwing two eggs from a building. Consider the previous question, but now suppose you only have two eggs, and your cost model is the number of throws. 
// Devise a strategy to determine F such that the number of throws is at most 2 sqrt(√ N), then find a way to reduce the cost to ~c √ F for some constant c.

public class SquareRootAndLinearSearch {
    private int[] a;
    private int f;
    private int n;

    public int findK(){
        int k = 1;
        while(k*Math.sqrt(n) < n && a[k*(int)Math.sqrt(n)] < f){
            k++;
        }
        System.out.println(k);
        return k;

    }

    public int findF(){
        int base = findK() - 1;
        int i = 0;
        while(a[base*(int)Math.sqrt(n) + i] <= f){
            i++;
        }
        System.out.println("Base: " + base + " i: " + i);
        return (base*(int)Math.sqrt(n) + i);
    }

    public static void main(String[] args) {
        SquareRootAndLinearSearch s = new SquareRootAndLinearSearch();
        s.a = new int[100];
        for (int i = 0; i < 100; i++) {
            s.a[i] = i + 1;
        }
        s.f = 23;
        s.n = 100;
        System.out.println(s.findF());
    }
}
