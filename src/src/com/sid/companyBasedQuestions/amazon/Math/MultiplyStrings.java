package src.com.sid.companyBasedQuestions.amazon.Math;

/***
 *https://leetcode.com/problems/multiply-strings/
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Ref :
 *
 * https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
 *
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 *
 *
 * **/
public class MultiplyStrings {

    /**
     * Strongly suggest to read this and this
     * <p>
     * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     * <p>
     * https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
     ***/
    public String multiply(String num1, String num2) {

        // i * j ---> [i+j,i+j+1]
        int product[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int d1 = (num1.charAt(i) - '0');
                int d2 = (num2.charAt(j) - '0');
                product[i + j + 1] += d1 * d2;

            }
        }

        int carry = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            int sum = carry + product[i];
            product[i] = sum % 10;
            carry = sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int p : product) {
            if (!(sb.length() == 0 && p == 0))//skip 0 in the begginning
                sb.append(p);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
