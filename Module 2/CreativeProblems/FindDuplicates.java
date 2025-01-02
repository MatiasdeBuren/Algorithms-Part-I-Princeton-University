package CreativeProblems;

import java.util.HashSet;
import java.util.Set;

// Given an array of N elements in which each element is an integer between 1 and N, write an algorithm to determine if there are any duplicates. Your algorithm should 
// run in linear time and use O(1) extra space
// Given an array of N+1 elements in which each element is an integer between 1 and N, write an algorithm to find a duplicate. Your algorithm should run in linear time,
// use O(1) extra space, and may not modify the original array

public class FindDuplicates {
    private int[] arr;
    private int N;

    public FindDuplicates(int[] arr) {
        this.arr = arr;
        this.N = arr.length;
    }

    // It is also possible to use a HashSet to solve this problem, but it would require O(N) space
    public int hasDuplicatesUsingHashSet() {
        Set<Integer> seen = new HashSet<>();
        for (int value : arr) {
            if (!seen.add(value)) {
                return value;
            }
        }
        return -1;
    }

    //with modification, this approach works only if values are between 1 and N. Cost O(N) time and O(1) space
    public boolean hasDuplicates() {
        for (int i = 0; i <= N - 1; i++){
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0){
                return true;
            }
            arr[index] = - arr[index];
            //System.out.println(arr[index]);
        }
        return false;
    }

    //without modification, array must have N+1 elements and values between 1 and N, this approach is based on Floyd's cycle detection algorithm
    //como los valores van de 1 a N, se puede pensar cada casilla como un puntero a otra casilla. 
    //El principio del array al tener un indice de 0, nunca se va a repetir (no es parte del ciclo), por lo que se puede pensar como el inicio de una lista enlazada
    //Como va a haber un valor repetido, hay dos casillas que apuntan a la misma casilla, que es el principio del ciclo y el valor repetido
    // Se basa en que la distancia que hay entre el principio del array y el principio del ciclo es igual a la distancia que hay entre la casiila donde se encuentran 
    //los dos punteros y el principio del ciclo
    public int findDuplicate(){
        int slow = arr[0];
        int fast = arr[0];
        
        slow = arr[slow];       // Move slow one step
        fast = arr[arr[fast]];  // Move fast two steps
        
        while (slow != fast) {
            slow = arr[slow];       // Move slow one step
            fast = arr[arr[fast]];  // Move fast two steps
            
        }

        System.out.println("Slow antes reset: "+slow);
        System.out.println("Fast antes reset: "+fast);
        slow = arr[0];

        while (slow != fast){
            slow = arr[slow];
            fast = arr[fast];
            System.out.println("Slow: "+slow);
            System.out.println("Fast: "+fast);
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 8, 6, 7, 5, 9, 10,11,12,13,14,12};
        int[] arr2 = {1, 15, 4, 3, 7, 6, 7, 5, 9,14,13,11,10,12,2,8};
        FindDuplicates fd = new FindDuplicates(arr);
        FindDuplicates fd2 = new FindDuplicates(arr2);
        System.out.println(fd2.findDuplicate());
        System.out.println(fd.hasDuplicates());
    }
}
