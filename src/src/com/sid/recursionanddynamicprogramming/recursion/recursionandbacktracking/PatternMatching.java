package src.com.sid.recursionanddynamicprogramming.recursion.recursionandbacktracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/pattern-matching-official/ojquestion#
 * <p>
 * Question
 * 1. You are given a string and a pattern.
 * 2. You've to check if the string is of the same structure as pattern without using any regular
 * expressions.
 * <p>
 * Sample Input
 * graphtreesgraph
 * pep
 * Sample Output
 * p -> graph, e -> trees, .
 */
public class PatternMatching {

    private void solution(String str, String pattern, HashMap<Character,String> map, String op){

        if(pattern.length()==0){
            if(str.length()==0){
                Set<Character> visitedChar=new HashSet<>();
                for(char ch :op.toCharArray()){
                    if(!visitedChar.contains(ch)){
                        visitedChar.add(ch);
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char pat=pattern.charAt(0);
        String rop=pattern.substring(1);

        if(map.containsKey(pat)){
            String previousMapping=map.get(pat);
            if(str.length() >= previousMapping.length()){
                String left=str.substring(0,previousMapping.length());
                String right=str.substring(previousMapping.length());
                //if the initial part of the string  matches the previous patter
                if(left.equals(previousMapping)){
                    solution(right,rop,map,op);
                }
            }
        }else{
            for(int i=0;i<str.length();i++){
                String left=str.substring(0,i+1);
                String right=str.substring(i+1);
                map.put(pat,left);
                solution(right,rop,map,op);
                map.remove(pat);
            }
        }




    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character,String> map = new HashMap<>();
        new PatternMatching().solution(str,pattern,map,pattern);
    }
}
