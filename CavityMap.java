/*https://www.hackerrank.com/challenges/cavity-map/problem*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        for(int i = 1; i < grid.length - 1 ; i++){
            StringBuilder line = new StringBuilder(grid[i]);
            for(int j = 1; j < grid[i].length() - 1; j++){
                int middleValue = (int) grid[i].charAt(j);
                int superiorValue = (int) grid[i-1].charAt(j);
                int bottomValue = (int) grid[i+1].charAt(j);
                int leftValue = (int) grid[i].charAt(j-1);
                int rightValue = (int) grid[i].charAt(j+1);
                if(middleValue > superiorValue &&
                   middleValue > bottomValue &&
                   middleValue > leftValue &&
                   middleValue > rightValue){
                       line.setCharAt(j, 'X');
                }
            }
            grid[i] = line.toString();
        }
        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
