package src.com.sid.algorithms.string.PatternMatching;

/**
 * Ref :
 * <p>
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 * <p>
 * KMP (Knuth Morris Pratt) Pattern Searching :
 * The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more than once in the pattern) of the pattern and improves the worst case complexity to O(n). The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches), we already know some of the characters in the text of the next window. We take advantage of this information to avoid matching the characters that we know will anyway match.
 * <p>
 * * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * * Space complexity - O(n)
 **/
public class KMP_String_Matching {

    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }

    private boolean KMPSearch(String pattern, String txt) {

        int[] lps = computeLPSArray(pattern);
        int i = 0; //index of txt
        int j = 0; //index of pattern

        while (i < txt.length() && j < pattern.length()) {

            if (pattern.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    System.out.println("Found pattern at index " + (i - j));
                    j = lps[j - 1];
                }
            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }

            }

        }
        if (j == pattern.length()) {
            return true;
        }

        return false;
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        // length of the previous longest prefix suffix
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    //find previous maximum match and don't increment i
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
