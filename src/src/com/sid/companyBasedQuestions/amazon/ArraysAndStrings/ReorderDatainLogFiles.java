package src.com.sid.companyBasedQuestions.amazon.ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * <p>
 * 937. Reorder Data in Log Files
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 **/
public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        // the idea is to implement a custom comparator of String to sort things in asc order
        //rules
        //0 letter logs first digit logs second
        //1 letter first digit as it is
        //2 letter if equal sort on basis of identifier

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {

                //split the log on the basis of first space ony
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2)//both are letter logs
                {
                    //sort like normal string
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)//if both are not equal
                    {
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                } else if (!isDigit1 && isDigit2)//first one is letter log
                {
                    return -1;
                } else if (isDigit1 && !isDigit2)//second one is letter log
                {
                    return 1;
                } else //both are digit logs
                {
                    return 0;
                }


            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(new ReorderDatainLogFiles().reorderLogFiles(logs));
    }
}
