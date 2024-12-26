package CreativeProblems;

// Throwing eggs from a building. Suppose that you have an N-story building and plenty of eggs. Suppose also that an egg is broken if it is thrown off floor F 
// or higher, and unbroken otherwise. First, devise a strategy to determine the value of F such that the number of broken eggs is ~ lg N when using ~ lg N throws, 
// then find a way to reduce the cost to ~ 2 lg F when N is much larger than F.

public class RepetedDoublingAndBS {
    private int[] a;
    private int n;
    private int F; // floor from which the egg breaks

    public int findRange(){
        int i = 1;
        while(i <= n && a[i] <= F){
            i *= 2;
        }
        return i;
    }

    public int findFloor(){
        int low = 0;
        int high = findRange();

        while (low <= high){
            int mid = (low + high) / 2;
            if(a[mid] == F){
                return mid;
            } else if(a[mid] < F){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RepetedDoublingAndBS obj = new RepetedDoublingAndBS();
        obj.a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,123,124,125,231,235,239,345,400,456,765,892,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000};
        obj.n = obj.a.length;
        obj.F = 1000;
        System.out.println(obj.findFloor());
    }
}
