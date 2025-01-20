//Counting inversions. An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j but a[i] > a[j]. Given an array, design a linearithmic algorithm to count the number 
//of inversions.

public class CountInversions {

    public static int countInversions(int[] array) {
        if (array == null || array.length < 2) {
            return 0; // No inversions in an empty or single-element array
        }
        int[] aux = new int[array.length];
        return countInversions(array, aux, 0, array.length - 1);
    }

    private static int countInversions(int[] array, int[] aux, int low, int high) {
        if (low >= high) {
            return 0; // Base case: no inversions in a single-element array
        }
        
        int mid = low + (high - low) / 2;
        int inversions = 0;

        // Count inversions in left half
        inversions += countInversions(array, aux, low, mid);
        // Count inversions in right half
        inversions += countInversions(array, aux, mid + 1, high);
        // Count split inversions and merge
        inversions += mergeAndCount(array, aux, low, mid, high);

        return inversions;
    }

    private static int mergeAndCount(int[] array, int[] aux, int low, int mid, int high) {
        System.arraycopy(array, low, aux, low, high - low + 1);

        int i = low;       // Pointer for left half
        int j = mid + 1;   // Pointer for right half
        int k = low;       // Pointer for merged array
        int inversions = 0;

        while (i <= mid && j <= high) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++]; // No inversion
            } else {
                array[k++] = aux[j++];
                // All remaining elements in the left half form inversions
                inversions += (mid - i + 1);
            }
        }

        // Copy remaining elements from the left half (if any)
        while (i <= mid) {
            array[k++] = aux[i++];
        }

        // Copy remaining elements from the right half (if any)
        while (j <= high) {
            array[k++] = aux[j++];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 3, 5};
        int inversions = countInversions(array);
        System.out.println("Number of inversions: " + inversions);
    }
}