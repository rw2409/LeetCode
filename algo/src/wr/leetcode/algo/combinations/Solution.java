package wr.leetcode.algo.combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine1(int n, int k) {

        Object[][] sols = new Object[2][k + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                List<List<Integer>> mySol = new LinkedList();
                if (i == 0 && j == 0) {
                    mySol.add(new LinkedList());
                } else if (i > 0) {
                    List<List<Integer>> lefts = (List<List<Integer>>) (sols[(i - 1) % 2][j]);
                    mySol.addAll(lefts);
                    if (j > 0) {
                        List<List<Integer>> rights = (List<List<Integer>>) sols[(i - 1) % 2][j - 1];
                        for (List<Integer> right : rights) {
                            List<Integer> sol = new LinkedList(right);
                            sol.add(i);
                            mySol.add(sol);
                        }
                    }
                }
                sols[i % 2][j] = mySol;
            }
        }
        return (List<List<Integer>>) sols[n % 2][k];
    }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new LinkedList<>();
            if(n == 0 && k == 0) {
                ret.add(new LinkedList<>());
                return ret;
            }
            List<List<Integer>> mySol = new LinkedList();
            if(n > 0 ) {
                mySol.addAll(combine(n-1, k));
                if(k > 0) {
                    List<List<Integer>> rights = combine(n - 1, k - 1);
                    for (List<Integer> right : rights) {
                        List<Integer> sol = new LinkedList(right);
                        sol.add(n);
                        mySol.add(sol);
                    }
                }
            }
            return mySol;
        }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4,2));
    }
}