import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.BiFunction;

/**
*
* The challenge "2D Array - DS" on Hackerrank
*
*/
public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        
		// Create a function which will sum together an hourglass
        BiFunction<Integer,Integer,Integer> sum = (x,y) ->{

            int total = arr[y + 1][x + 1]; // The middle value
            
            for(int x1 = 0; x1 < 3; x1++){
                total += arr[y][x + x1] + arr[y + 2][x + x1]; // The bottom and top rows
            }

            return total;
        };
        
        int highestSum = Integer.MIN_VALUE; // The highest sum found
        
        for(int x = 0; x < arr.length-2; x++) { // Go through all x values
            for(int y = 0; y < arr.length-2; y++) { // And all y values
			
				// Pick the highest sum
                highestSum = Math.max(highestSum, sum.apply(x, y));
            }
        }
        
        return highestSum; // Return the answer
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
