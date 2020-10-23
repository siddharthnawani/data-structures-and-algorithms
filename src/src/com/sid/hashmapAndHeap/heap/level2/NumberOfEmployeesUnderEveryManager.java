package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/number-of-employees-under-every-manager-official/ojquestion#
 * <p>
 * Question
 * 1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
 * 2. An employee directly reports to only one manager.
 * 3. All managers are employees but the reverse is not true.
 * 4. An employee reporting to himself is the CEO of the company.
 * 5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
 * Sample Input
 * 6
 * A C
 * B C
 * C F
 * D E
 * E F
 * F F
 * Sample Output
 * A 0
 * B 0
 * C 2
 * D 0
 * E 1
 * F 5
 **/
public class NumberOfEmployeesUnderEveryManager {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(in.next(), in.next());
        }
        findCount(hm);
    }

    private static void findCount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";

        for (String emp : map.keySet()) {
            String mgr = map.get(emp);

            if (mgr.equals(emp)) {
                ceo = emp;
            } else {
                if (tree.containsKey(mgr)) {
                    HashSet<String> rep = tree.get(mgr);
                    rep.add(emp);

                } else {
                    HashSet<String> rep = new HashSet<>();
                    rep.add(emp);
                    tree.put(mgr, rep);
                }
            }

        }

        HashMap<String, Integer> res = new HashMap<>();
        getSize(tree, ceo, res);

        for (String mgr : res.keySet()) {
            System.out.println(mgr + " " + res.get(mgr));
        }

    }

    private static int getSize(HashMap<String, HashSet<String>> tree, String mgr, HashMap<String, Integer> res) {

        if (tree.containsKey(mgr) == false) {
            res.put(mgr, 0);
            return 1;
        }

        int sz = 0;

        for (String emp : tree.get(mgr)) {
            int child = getSize(tree, emp, res);
            sz += child;
        }

        res.put(mgr, sz);

        // Plus 1 for himself as well
        return sz + 1;

    }
}
