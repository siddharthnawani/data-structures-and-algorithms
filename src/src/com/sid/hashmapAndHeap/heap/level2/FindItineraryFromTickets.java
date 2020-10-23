package src.com.sid.hashmapAndHeap.heap.level2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-itinerary-from-tickets-official/ojquestion#
 * <p>
 * Question
 * 1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
 * 2. You have to find the itinerary in order using the given list of tickets.
 * <p>
 * Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
 * <p>
 * Sample Input
 * 4
 * Chennai Banglore
 * Bombay Delhi
 * Goa Chennai
 * Delhi Goa
 * Sample Output
 * Bombay -> Delhi -> Goa -> Chennai -> Banglore.
 **/
public class FindItineraryFromTickets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        HashMap<String, Boolean> psrc = new HashMap<>();

        for (String src : map.keySet()) {
            String des = map.get(src);

            psrc.put(des, false);
            if (psrc.containsKey(src) == false) {
                psrc.put(src, true);
            }

        }

        String src = "";
        for (String city : psrc.keySet()) {
            if (psrc.get(city) == true) {
                src = city;
                break;
            }
        }

        while (true) {
            if (map.containsKey(src)) {
                System.out.print(src + " -> ");
                src = map.get(src);
            } else {
                System.out.println(src + ".");
                break;
            }
        }


    }
}
