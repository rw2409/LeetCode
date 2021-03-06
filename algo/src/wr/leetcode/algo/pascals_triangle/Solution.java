package wr.leetcode.algo.pascals_triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        if( numRows > 0) {
            ArrayList<Integer> prev = new ArrayList<>();
            for (int i = 1; i <= numRows; ++i ) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < i; ++j) {
                    int val;
                    if(0 == j || i-1 == j) {
                        val = 1;
                    } else {
                        val = prev.get(j-1) + prev.get(j);
                    }
                    row.add(val);
                }
                ret.add(row);
                prev = row;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> ans = new Solution().generate(5);
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }



        /*
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ret = new ArrayList<>(numRows);
        for (int l = 1; l <= numRows; ++l ) {
            List<Integer> row = new ArrayList<>(l);
            for (int i = 0; i<l; ++i) {
                if(i == 0 || i == l-1) {
                    row.add(1);
                } else {
                    int val = 0;
                    val += ret.get(l-2).get(i-1);
                    val += ret.get(l-2).get(i);
                    row.add(val);
                }
            }
            ret.add(row);
        }
        return ret;
    }*/
}
