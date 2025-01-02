package CreativeProblems;

//Given an array of N strings. An element is a majority if it appears more than N/2 times. Devise an algorithm to identify the majority if it exists. Your algorithm 
//should run in linearithmic time.Repeat the previous exercise, but this time your algorithm should run in linear time, and only use a constant amount of extra space. 
//Moreover, you may only compare elements for equality, not for lexicographic order.

public class Majority {
    private String[] a;
    private int n;

    public Majority(String[] a) {
        this.a = a;
        this.n = a.length;
    }

    //Es lineal por ser un solo ciclo for y es boyer-moore
    public String findMajority(){
        int cont = 0;
        String champion = "";
        for (int i = 0; i < n - 1; i++){
            if(cont == 0){
                champion = a[i];
            }
            if(a[i] == champion){
                cont++;
            }else{
                cont--;
            }
        }
        return champion;
    }

    public static void main(String[] args) {
        String[] a = {"d", "a", "l", "m", "o", "d", "o", "d", "o", "c", "d", "d", "d", "d", "d"};
        Majority majority = new Majority(a);
        System.out.println(majority.findMajority());
    }
}
