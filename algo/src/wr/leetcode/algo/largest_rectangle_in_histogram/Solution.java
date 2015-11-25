package wr.leetcode.algo.largest_rectangle_in_histogram;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /*public int largestRectangleArea(int[] h) {
        if(null == h) {
            h = new int[0];
        }
        int[] height = new int[h.length +2];
        System.arraycopy(h, 0, height, 1, h.length );
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            if(!stack.isEmpty() && height[stack.peek()] > height[i]) {
                while(!stack.isEmpty() && height[stack.peek()] > height[i]){
                    int j = stack.pop();
                    maxArea = Math.max(maxArea, (i-stack.peek()-1)*height[j]);
                }
            }
            stack.push(i);
        }
        return maxArea;
    }*/

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        int[] b = {2,1,2};
        int[] c = {4,2};
        int[] d = {6,5,4};

        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(a));
        System.out.println(sol.largestRectangleArea(b));
        System.out.println(sol.largestRectangleArea(c));
        System.out.println(sol.largestRectangleArea(d));

    }

    public int largestRectangleArea(int[] height) {
        if(null == height || 0 == height.length) {
            height = new int[0];
        }
        int [] h = new int[height.length + 2];
        for (int i = 0; i < height.length; ++i) {
            h[i+1] =  height[i];
        }
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < h.length; ++i){
            if(st.isEmpty() || h[i] >= h[st.peek()]) {
                st.push(i);
            } else {
                while(!st.isEmpty() && h[st.peek()] > h[i]) {
                    int t = st.pop();
                    int area = (i- st.peek() - 1) * h[t];
                    if(area > max) {
                        max = area;
                    }
                }
                st.push(i);
            }
        }
        return max;
    }

}
