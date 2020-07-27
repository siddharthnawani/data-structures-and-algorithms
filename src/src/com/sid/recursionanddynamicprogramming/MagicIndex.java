package src.com.sid.recursionanddynamicprogramming;
/***
 * Magic Index: A magic index in an array A[ 1.•.n-1] is defined to be an index such that A[ i]
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 *
 * **/
public class MagicIndex {

    public static int magicFast(int[] array, int start, int end){
        if(start > end)return -1;
        int mid=start + (end-start)/2;
        if(array[mid]==mid)
            return mid;
        else if(array[mid] > mid)
            return magicFast(array,start,mid-1);
        else
            return magicFast(array,mid+1,end);

    }
    //Follow up- what if there are dupliated in the array

    public static int magicFastWithDuplicates(int[] array, int start, int end){
        if(start > end)return -1;
        int mid=start + (end-start)/2;
        if(array[mid]==mid)
            return mid;

        int li=Math.min(mid-1,array[mid]);
        int left=magicFastWithDuplicates(array,start,li);
        if(left >=0)return left;

        int ri=Math.max(mid+1,array[mid]);
        int right=magicFastWithDuplicates(array,ri,end);

        return right;
    }



    public static void main(String[] args) {
        int[] A = { -1, 0, 1, 2, 4, 10 };
        System.out.println(magicFast(A,0,A.length-1));
        int[] B={-10,-5,2,2,2,3,4,7,9,12,13};
        System.out.println(magicFastWithDuplicates(B,0,B.length-1));
    }
}
