/* https://www.hackerrank.com/challenges/the-grid-search/problem */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        // iterando sobre linhas
        for (int line = 0; line < G.length; line++) {
            //verificando se padrao existe comecando de cada digito
            for(int digit = 0; digit < G[line].length(); digit++) {
                int indexPatternFound = G[line].indexOf(P[0], digit);
                //se encontrou padrao entao verifica linhas adiante
                if (indexPatternFound != -1) {
                    boolean patternFound = true;

                    for (int j = 1, k = line + 1; j < P.length && k < G.length; j++, k++) {
                        int newIndexPatternFound = G[k].indexOf(P[j], digit);

                        if (newIndexPatternFound != indexPatternFound) {
                            patternFound = false;
                            break;
                        }
                    }
                    if (patternFound) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
