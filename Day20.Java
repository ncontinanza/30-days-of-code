import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] bubbleSort(int n, int[] a) {
        int numberOfSwaps = 0;
        for (int i = 0; i < n; i++) {  
            int traversalSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    traversalSwaps++;
                }
            }
        
            // If no elements were swapped during a traversal, array is sorted
            if (traversalSwaps == 0) {
                break;
            }
            numberOfSwaps += traversalSwaps;
        }

        System.out.printf("Array is sorted in %d swaps.\n", numberOfSwaps);
        return a;
    }    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        a = bubbleSort(n, a);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[n-1]);
    }
}

