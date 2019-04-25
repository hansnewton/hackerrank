/*https://www.hackerrank.com/challenges/strange-code/problem*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long max;
        long column = 1;
        long result;
        double potencia;
        while(true){
            potencia = Math.pow(2, column-1);
            max = (long)potencia * 3 - 2 + (long)potencia * 3 - 1;
            if( t <= max) {
                result = max - (t-1); 
                break;
            }
            column++;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/** explicação */
/*# 1 coluna
2^0 * 3 (3 elementos)
ini = 2^0*3 - 2  = 1
max = 2^0*3 -2 + 2^0*3 -1 =3

# 2 coluna
2ˆ1 * 3 (6 elementos)
ini = 2ˆ1 * 3 - 2  = 4
max = (2ˆ1 * 3 - 2) + 2ˆ1 * 3 - 1 = 9

# 3 coluna
2ˆ2 * 3 (12 elementos)
ini: 2ˆ2 * 3 - 2 = 10
max: (2ˆ2 * 3 - 2) +(2ˆ2 * 3 - 1) = 21
10 ate 21

# 4 coluna
2^3 * 3 (24 elementos)
ini: 24 - 2 = 22
max: 24 - 2 + 24 -1= 22+23=45

max - (n-1)


valor de 2 = 3-1 = 2
      de 1 = 3-0 = 3
      de 3 = 3-2 = 1

valor de 4 ?
descubro o intervalo : 2
qual o max ? : 
retorno max - (n-1)*/

