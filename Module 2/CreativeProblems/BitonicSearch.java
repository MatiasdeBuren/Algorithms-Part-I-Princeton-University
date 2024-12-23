package CreativeProblems;

// Bitonic search. An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. 
// Write a program that, given a bitonic array of n distinct int values, determines whether a given integer is in the array. Your program should 
// use ~ 3 log n compares in the worst case.

public class BitonicSearch {
    private int[] a;
    private int n;

    public BitonicSearch(int[] a){
        this.a = a;
        this.n = a.length;
    }

    public boolean findBitonic(int value){
        int low = 0;
        int high = n - 1;
        int indexMaxValue = 0;

        while (low <= high){
            int mid = (low + high) / 2;
            if (a[mid] == value){
                return true;
            }
            if (a[mid + 1] > a[mid]){
                low = mid + 1;
            }
            if (a[mid] > a[mid + 1]){
                high = mid - 1;
            }
            if (a[mid] > a[indexMaxValue]){
                indexMaxValue = mid;
            }
        }
        return normalBinarySearch(0, indexMaxValue, value) || reverseBinarySearch(indexMaxValue, n - 1, value);
    }

    public boolean normalBinarySearch(int start,int end,int value){
        int low = start;
        int high = end;
        while (low <= high){
            int mid = (low + high) / 2;
            if (a[mid] == value){
                return true;
            }
            if (value < a[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean reverseBinarySearch(int start,int end,int value){
        int low = start;
        int high = end;
        while (low <= high){
            int mid = (low + high) / 2;
            if (a[mid] == value){
                return true;
            }
            if (value < a[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] a = {1, 3, 5, 7, 9, 14,16,20,12,11,8, 6, 4, 2};
        BitonicSearch bs = new BitonicSearch(a);
        boolean found = bs.findBitonic(14);
        System.out.println("Found: " + found);
    }
}
