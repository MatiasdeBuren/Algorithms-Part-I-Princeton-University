package CreativeProblems;

// Binary search with duplicates. Modify binary search so that it always returns the smallest (largest) index of a key of an item matching
//  the search key.

public class BinarySearchWithDuplicates {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9};
        BinarySearchWithDuplicates binarySearchWithDuplicates = new BinarySearchWithDuplicates(a);
        System.out.println(binarySearchWithDuplicates.find(4));
    }

    private int[] a;

    public BinarySearchWithDuplicates(int[] a) {
        this.a = a;
    }

    public int find(int value){
        int low = 0;
        int high = a.length - 1;
        int maxValueIndex = -1;

        while (low <= high){
            //System.out.println("hola");
            int mid = (low + high) / 2;
            if (a[mid] == value && mid > maxValueIndex){
                maxValueIndex = mid;
            }
            if (a[mid] <= value){
                low = mid + 1;
            }
            else{
                high = mid - 1;
                // System.out.println("hola");
            }
        }
        return maxValueIndex;
    }

}
