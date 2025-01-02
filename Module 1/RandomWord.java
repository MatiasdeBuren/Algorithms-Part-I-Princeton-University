import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        int i = 1;
        String challenger = StdIn.readString();
        while (!challenger.equals("exit") && !StdIn.isEmpty()) {
            if (StdRandom.bernoulli(1.0 / i)) {
                champion = challenger;
            }
            i++;
            challenger = StdIn.readString();
        }
        StdOut.println(champion);
    }
}
