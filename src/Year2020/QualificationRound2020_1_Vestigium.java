package Year2020;

/*
Question 1
main page : https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
(Vestigium): https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
 */

/*
For Cloning a 2D-Array. you should clone row by row : input[index] =  matrix[index].clone();
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class QualificationRound2020_1_Vestigium {

    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter w = new PrintWriter(System.out);

    public static void main(String[] args) {


        int numberOfTestCases = Integer.parseInt(sc.nextLine());
        for(int testcase = 1; testcase <= numberOfTestCases; testcase++) {
            int sizeOfMatrix = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            for(int i = 0; i < sizeOfMatrix; i++){
                String line = sc.nextLine();
                String[] splitedLineString =  line.split(" ");
                for(int j = 0; j < sizeOfMatrix; j++){
                     matrix[i][j] = Integer.parseInt(splitedLineString[j]);
                 }
            }

            int trace = getTrace(matrix);
            int[][] input = new int[sizeOfMatrix][sizeOfMatrix];
            for(int index = 0; index < sizeOfMatrix; index++){
                input[index] =  matrix[index].clone();
            }

            int numberOfRepeatedRows = getNumberOfRepeatedRows(input);
            int numberOfRepeatedColumns =  getNumberOfRepeatedColumns(matrix);
            w.println("Case #" + testcase + ": " + trace + " " + numberOfRepeatedRows + " "+ numberOfRepeatedColumns);
        }

        w.close();
        sc.close();
    }
    private static int getNumberOfRepeatedColumns(int[][] matrix) {
        int sizeOfMatrix = matrix.length;
        int numberOfRepeatedColumns= 0;
        int[] column = new int[sizeOfMatrix];

        for(int i = 0; i < sizeOfMatrix; i++) {
            for(int j = 0; j < sizeOfMatrix; j++){
               column[j] = matrix[j][i];
            }
            Arrays.sort(column);

            for(int j = 0; j < sizeOfMatrix; j++){
                if(column[j] != (j +1)){
                    numberOfRepeatedColumns++;
                    break;
                }
            }
        }
        return numberOfRepeatedColumns;
    }

    private static int getNumberOfRepeatedRows(int[][] matrix) {
        int sizeOfMatrix = matrix.length;
        int numberOfRepeatedRows= 0;
        for(int i = 0; i < sizeOfMatrix; i++) {
            Arrays.sort(matrix[i]);
            for(int j = 0; j < sizeOfMatrix; j++){
                if(matrix[i][j] != (j +1)){
                    numberOfRepeatedRows++;
                    break;
                }
            }
        }
        return numberOfRepeatedRows;
    }

    private static int getTrace(int[][] matrix) {
        int sizeOfMatrix = matrix.length;
        int sum = 0;
        for(int i = 0; i < sizeOfMatrix; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
