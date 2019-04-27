/*https://www.hackerrank.com/challenges/maximum-element/problem*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.List;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] sequence = new int[N][2];
        for(int i=0;i<N;i++){
            sequence[i][0] = in.nextInt();
            if(sequence[i][0] == 1){
                sequence[i][1] = in.nextInt();
            }
        }
        maximumElement(sequence);
    }

    public static void maximumElement(int[][] sequence){
        List<Integer> elements = new LinkedList<>();
        for(int i = 0; i < sequence.length; i++){
            int op = sequence[i][0];
            switch(op){
                //insert element
                case 1: {
                    elements.add(sequence[i][1]);
                    break;
                }
                // remove element
                case 2: {   
                    elements.remove(elements.size()-1);
                    break;
                }
                // show max element
                case 3: {
                    int max = Collections.max(elements,new Comparator<Integer>(){
                        public int compare(Integer num1, Integer num2){
                            return num1 < num2 ? -1 : num1 > num2 ? 1 : 0;
                        }
                    });
                    
                    System.out.println(max);
                    break;
                }
            }
        }
    }
}

