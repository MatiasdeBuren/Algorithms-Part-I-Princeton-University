//Suppose that the subarray a[0] to a[n-1] is sorted and that the subarray a[n] to a[2*n-1] is sorted. How can you merge the two subarrays so that a[0] to a[2*n-1] is sorted using 
//an auxiliary array of length n (instead of 2n)?

public class MergingWithSmallerAuxArray {
    private int[] arr;
    private int[] aux;
    private int n;

    public MergingWithSmallerAuxArray(int[] arr) {
        this.arr = arr;
        this.n = arr.length / 2;
        this.aux = new int[n];
    }

    public void merge() {
        for (int i = 0; i < n; i++) {
            aux[i] = arr[i];
        }

        int i = 0;
        int j = n;
        int k = 0;

        while (i < n && j < 2 * n) {
            if (aux[i] <= arr[j]) {
                arr[k++] = aux[i++]; //Esto es una forma de ahorrarse hacer a[k] = aux[i]; k++; i++; Accede al elemento y despues incrementa el indice
            } else {
                arr[k++] = arr[j++];
            }
        }

        while (i < n) {
            arr[k++] = aux[i++];
        }
    }
}
