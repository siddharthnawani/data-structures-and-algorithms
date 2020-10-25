package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/***
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-with-exactly-k-unique-characters-official/ojquestion#
 *
 * Question
 * 1. You are given a string(str) and a number K.
 * 2. You have to find the count of valid substrings of the given string.
 * 3. Valid substring is defined as a substring that has exactly K unique characters.
 *
 * Sample Input
 * aabcbcdbca
 * 2
 * Sample Output
 * 12
 *
 * **/
public class CountOfSubstringsWithExactlyKUniqueCharacters {
    private static int handleFork1(String str, int k) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == 2) {
                    removeInMap(map, ch);
                    i--;
                    break;
                }
            }

            while (j < i) {
                f2 = true;
                if (map.size() == k) { // same as writing map.size() ==0
                    ans += i - j;
                }

                j++;
                char ch = str.charAt(j);
                removeInMap(map, ch);
                if (map.size() < k) {
                    break;
                }

            }

            if (f1 == false && f2 == false) {
                break;
            }

        }


        return ans;
    }

    public static int solution(String str, int k) {
        int ans = 0;

        if (k == 1) {
            return handleFork1(str, k);
        }

        HashMap<Character, Integer> mapb = new HashMap<>();
        HashMap<Character, Integer> maps = new HashMap<>();
        int is = -1;
        int ib = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;

            //keep k element in big map
            while (ib < str.length() - 1) {
                f1 = true;
                ib++;
                char ch = str.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
                if (mapb.size() == k + 1) {
                    removeInMap(mapb, ch);
                    ib--;
                    break;
                }
            }

            //keep k-1 element in small map
            while (is < ib) {
                f2 = true;
                is++;
                char ch = str.charAt(is);
                maps.put(ch, maps.getOrDefault(ch, 0) + 1);
                if (maps.size() == k) {
                    removeInMap(maps, ch);
                    is--;
                    break;
                }
            }

            //between k-1 and k element you will find substrings with eactly 3 unique characters
            while (j < is) {
                f3 = true;
                //collect
                if (mapb.size() == k && maps.size() == k - 1) {
                    ans += ib - is;
                }
                //release characters from behind
                j++;
                char ch = str.charAt(j);
                removeInMap(maps, ch);
                removeInMap(mapb, ch);

                //break when any of the hash map become invalid
                if (maps.size() < k - 1 || mapb.size() < k) {
                    break;
                }


            }

            if (f1 == false && f2 == false && f3 == false) {
                break;
            }

        }
        return ans;
    }

    private static void removeInMap(HashMap<Character, Integer> map, char ch) {
        if (map.get(ch) == 1) {
            map.remove(ch);
        } else {
            map.put(ch, map.get(ch) - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }
}
