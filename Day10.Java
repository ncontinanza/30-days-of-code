import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    private static Stack<Integer> getStackedBinary(int decimal){
        Stack<Integer> stack = new Stack<Integer>();
        int remainder;
        while(decimal > 0){
            remainder = decimal % 2;
            decimal = decimal / 2;
            stack.push(remainder);
        }
        return stack;
    }

    private static int getConsecutiveOnes(Stack<Integer> stackedBinary){
        int consecutiveOnes = 0;
        int partialSum = 0;
        while(!stackedBinary.empty()){
            if (stackedBinary.pop() == 0){
                if (partialSum > consecutiveOnes) {
                    consecutiveOnes = partialSum;
                }
                partialSum = 0;
            } else {
                partialSum++;
            }
        }
        return (partialSum > consecutiveOnes) ? partialSum : consecutiveOnes;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        Stack<Integer> stackedBinary = getStackedBinary(n);
        System.out.println(getConsecutiveOnes(stackedBinary));

    }
}
