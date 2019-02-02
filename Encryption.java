import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.*;

/**
* A solution to the "Encryption" medium challenge on HackerRank
*
* @author Wilfrid Askins
*/
public class Solution {

    /**
    * Encrypts a string using the HackerRank-specified algorithm
    *
    * @param s the string to encrypt
    */
    static String encryption(String s) {

        s = s.replace(" ", ""); // remove all spaces
        int L = s.length(); // get the length of the string

        double sqrtL = Math.sqrt(L); // the length square root
        int floor = (int) Math.floor(sqrtL); // the square root rounded down
        int ceil = (int) Math.ceil(sqrtL); // the square root rounded up

        if(floor*ceil < L) floor += 1; // If the grid needs to be expanded

        final String str = s; // Final copy of the string

        // Used to safely get the char at the specified index
        Function<Integer,String> charAt = i -> i > str.length()-1? "" : ""+str.charAt(i);

        String output = ""; // The text to be returned

        // For each column
        for(int col = 0; col < ceil; col++){

            // For each row
            for(int i = 0; i < floor; i++){
                // Add the needed character to the output
                output += charAt.apply(i * ceil + col);
            }

            // Add a space to the output
            output += " ";
        }

        // Return the encrypted string
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
