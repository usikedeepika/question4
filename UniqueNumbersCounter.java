package org.ness;

import java.util.*;

public class UniqueNumbersCounter {
    //    public static void main(String[] args) {
//        int[] arr = {6,10,4,5,2,1,2};
//        System.out.println(findUniqueNumbersCount(arr,-4));
//    }
    public static String findUniqueNumbersCount(int[] arr,int subArrLen){
        String outString = "";
        if(arr.length == 0){
            return outString += "Give proper input not empty array";
        } else if (arr == null) {
            return outString += "Give proper input not null array";
        } else if (arr.length < subArrLen) {
            return outString += "Give proper input, sub array length exceeds array length";
        } else if (subArrLen <= 0) {
            return outString += "Give proper input, sub array length can not be negative or zero";
        } else {
            Deque<Integer> deque = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if(i < subArrLen - 1){
                    deque.add(arr[i]);
                    set.add(arr[i]);
                } else if (i >= subArrLen - 1) {
                    if(set.size()>max){
                        max = set.size();
                    }
                    Integer removedInt = deque.removeFirst();
                    set.remove(removedInt);
                    deque.add(arr[i]);
                    set.add(arr[i]);
                }
            }
            outString += "Count of Unique Numbers is " + max;
            return outString;
        }
    }
}