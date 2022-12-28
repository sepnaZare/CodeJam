package Year2020;
/*
Question 1
main page : https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74

(Pattern Matching): https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd74/00000000002b3034
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter w = new PrintWriter(System.out);

    public static void main(String[] args) {
        int numberOfTestCases = Integer.parseInt(sc.nextLine());
        for(int testcase = 1; testcase <= numberOfTestCases; testcase++) {
            int numberOfPatterns = Integer.parseInt(sc.nextLine());
            String[] patterns = new String[numberOfPatterns];

            for(int j = 0; j < numberOfPatterns; j++) {
                patterns[j] = sc.nextLine();
            }

            String longestString = getLongestStringforPattern(patterns);

            w.println("Case #" + testcase + ": " + longestString);
        }

        w.close();
        sc.close();

    }


    private static String getLongestStringforPattern(String[] patterns) {
        // firstPart*XXX*lastPart
        String firstPart = matchFirstPart(patterns);
        String lastPart = matchLastPart(patterns);

        if(firstPart.indexOf("0") >= 0 || lastPart.indexOf("0") >=0)
            return "*";

        return firstPart  + concatinationOfTheRemaining(patterns) + lastPart;
    }

    private static String matchFirstPart(String[] patterns) {
        String[] firstPart = new String[patterns.length];
        int i = 0;

        for (String element: patterns) {
            String[] splited = element.split("\\*", 2); // split it to two parts: with teh first occurance of "*"
            firstPart[i] = splited[0];
            patterns[i] =  "*" + splited[1];
            i++;
        }

        // find the longest String in an Array based on the size
        String longest = Arrays.stream(firstPart).
                max(Comparator.comparingInt(String::length)).get();

        // check if the other patterns match with the longest
        for (String element: firstPart) {
            // ^regex : checks that the begining of the string match the regex
            Matcher matcher  = (Pattern.compile("^" + element)).matcher(longest);

            if(element.length() > 0  && !matcher.find()) {
                return "0";
            }
        }
        return longest;
    }

    private static String matchLastPart(String[] patterns) {
        String[] lastPart = new String[patterns.length];

        int i = 0;
        for (String element: patterns) {
            // split it to two parts: with the last occurance of "*"
            int index = element.lastIndexOf("*");

            if(index <= 0 && element.length() <= 1){lastPart[i] = ""; patterns[i] = "";}
            else if (index == 0 && element.length() > 1){
                lastPart[i] = element.substring(index+1);
                patterns[i] = "";
            }
            else {
                String[] splited = {element.substring(0, index), element.substring(index+1)};
                lastPart[i] = splited[1];
                patterns[i] = splited[0] + "*";
            }
            i++;
        }

        String longest = Arrays.stream(lastPart).
                max(Comparator.comparingInt(String::length)).get();

        for (String element: lastPart) {
            // regex$ : checks that the enging of the string match the regex
            Matcher matcher  = (Pattern.compile(element+ "$")).matcher(longest);
            if(element.length() > 0  && !matcher.find()) {
                return "0";
            }
        }
        return longest;
    }

    // concatinate the middle part of the regular expression, such as M*N*B: concatinate N prt of the regex
    private static String concatinationOfTheRemaining(String[] patterns) {
        String result  = "";
        for (String element: patterns) {
            result =  result + element.replace("*", "");
        }
        return  result;
    }

}
