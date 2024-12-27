package CreativeProblems;

// Floor and ceiling. Given a set of comparable elements, the ceiling of x is the smallest element in the set greater than or equal to x, and the floor is the largest
// element less than or equal to x. Suppose you have an array of N items in ascending order. Give an O(log N) algorithm to find the floor and ceiling of x.

public class FloorAndCeiling {
    private int[] arr;
    private int N;

    public FloorAndCeiling(int[] arr) {
        this.arr = arr;
        this.N = arr.length;
    }

    public int[] floor(int x) {
        int low = 0;
        int high = N - 1;
        int floor = 0;
        int ceiling = arr[N-1];

        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == x){
                return new int[]{arr[mid], arr[mid]};
            }
            if (arr[mid] < x){
                floor = arr[mid];
                low = mid + 1;
            }
            if (arr[mid] > x){
                ceiling = arr[mid];
                high = mid - 1;
            }
        }
        return new int[]{floor,ceiling};
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,9,10,11,15,17,18,25,26,27,28,29,32,34,35,36,37,38,39,40,41,42,43,44,45,46,47,50};
        FloorAndCeiling fc = new FloorAndCeiling(arr);
        int[] res = fc.floor(2);
        System.out.println("Floor: " + res[0] + " Ceiling: " + res[1]);
    }
}
