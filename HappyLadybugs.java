/*https://www.hackerrank.com/challenges/happy-ladybugs/problem*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        boolean qtdCoresSuficiente = true;
        boolean espaco = false;
        boolean qtdCoresMenorQueDois = false;
        boolean happy = true;
        int[] color = new int[32];
        for(int i = 0 ; i < b.length() ; i++){
            color[((int)b.charAt(i))%64]++;
        }
        if(color[31]>0){
            espaco = true;
        }
       

        for(int i = 1 ; i < b.length()-1 ; i++){
            if(b.charAt(i) != b.charAt(i-1) && b.charAt(i) != b.charAt(i+1)){
                happy = false;
                break;
            }
        }

        for(int i = 1; i < 27; i++){
            if(color[i] == 0){
                continue;
            }
            if(color[i] == 1){
                qtdCoresSuficiente = false;
                return "NO";
            }
        }

        if (qtdCoresSuficiente && espaco){
            return "YES";
        }

        if(happy){
            return "YES";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
