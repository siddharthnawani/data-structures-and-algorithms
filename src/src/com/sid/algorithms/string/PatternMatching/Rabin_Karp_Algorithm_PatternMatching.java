package src.com.sid.algorithms.string.PatternMatching;

/**
 * https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
 * https://www.youtube.com/watch?v=qQ8vS2btsxI
 * https://www.youtube.com/watch?v=H4VrKHVG5qI
 * <p>
 * https://leetcode.com/problems/implement-strstr/solution/
 * 28. Implement strStr()
 **/
public class Rabin_Karp_Algorithm_PatternMatching {

    //haystck is the tet ; needle is the pattern
    public int strStr(String haystack, String needle) {

        int T = haystack.length(), P = needle.length();

        if (P > T) return -1;

        //base value for rolling hash fucntion
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 31);

        long patternHash = 0, textHash = 0;

        for (int i = 0; i < P; i++) {
            patternHash = (patternHash * a + charToInt(i, needle)) % modulus;
            textHash = (textHash * a + charToInt(i, haystack)) % modulus;
        }

        if (patternHash == textHash)
            return 0;

        long aL = 1;
        // const value to be used often : a**L % modulus
        for (int i = 1; i <= P; i++)
            aL = (aL * a) % modulus;

        for (int start = 1; start < T - P + 1; start++) {
            textHash = ((textHash * a - charToInt(start - 1, haystack) * aL) + charToInt(start + P - 1, haystack)) % modulus;
            if(patternHash==textHash)
                return start;
        }

        return -1;
    }

    private int charToInt(int i, String needle) {

        return needle.charAt(i) - (int) 'a';
    }

    public static void main(String[] args) {
        String text="hello";
        String pattern="ll";

        System.out.println(new Rabin_Karp_Algorithm_PatternMatching().strStr(text,pattern));
    }

}
