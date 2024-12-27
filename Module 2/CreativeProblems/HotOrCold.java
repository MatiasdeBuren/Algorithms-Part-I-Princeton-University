package CreativeProblems;

// Hot or cold. Your goal is the guess a secret integer between 1 and N. You repeatedly guess integers between 1 and N. After each guess you learn if it equals the 
// secret integer (and the game stops); otherwise (starting with the second guess), you learn if the guess is hotter (closer to) or colder (farther from) the secret 
// number than your previous guess. Design an algorithm that finds the secret number in ~ 2 lg N guesses. Then, design an algorithm that finds the secret number 
// in ~ 1 lg N guesses.

public class HotOrCold {

    private int secret;
    private int N;

    public HotOrCold(int N) {
        this.N = N;
        this.secret = (int) (Math.random() * N) + 1;
    }

    public int hotterOrColder(int guess, int prevGuess) {
        int diff1 = Math.abs(secret - guess);
        int diff2 = Math.abs(secret - prevGuess);
        if (diff1 < diff2) {
            return -1;
        } else {
            return 1;
        }
    }


}