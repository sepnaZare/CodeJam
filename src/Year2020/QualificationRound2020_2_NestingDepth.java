package Year2020;

/*
Question 1
main page : https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
(Nesting Depth): https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f
 */

/*

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class QualificationRound2020_2_NestingDepth {

    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter w = new PrintWriter(System.out);

    public static void main(String[] args) {
         int numberOfTestCases = Integer.parseInt(sc.nextLine());
         for(int testcase = 1; testcase <= numberOfTestCases; testcase++) {
            String digitString = sc.nextLine();
            w.println(digitString);
         }
    }
}
