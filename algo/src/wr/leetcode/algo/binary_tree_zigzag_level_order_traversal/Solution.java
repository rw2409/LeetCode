package wr.leetcode.algo.binary_tree_zigzag_level_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
   /* public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    	List<List<Integer>> ret = new LinkedList<>();
    	if (null == root) {
    		return ret;
    	}

    	Queue<TreeNode> next = new LinkedList<>();
    	next.add(root);
    	boolean reverse = false;
    	while(!next.isEmpty()) {
	    	LinkedList<Integer> line = new LinkedList<>();
	    	Queue<TreeNode> curr = next;
	    	next = new LinkedList<>();
			while(!curr.isEmpty()) {
				TreeNode node = curr.poll();
				if(reverse) {
					line.addLast(node.val);
				}else{
					line.addFirst(node.val);
				}

				if(null != node.left) {
					next.add(node.left);
				}
				if(null != node.right) {
					next.add(node.right);
				}
			}
			ret.add(line);
			reverse = !reverse;
    	}
    	return ret;
    }*/
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	   List<List<Integer>> ret = new LinkedList<>();
	   Queue<TreeNode> q = new LinkedList<>();
	   if(null != root) {
		   q.add(root);
	   }
	   boolean isReverse = false;
	   while(!q.isEmpty()) {
		   LinkedList<Integer> r = new LinkedList<>();
		   Queue<TreeNode> nextQ = new LinkedList<>();
		   while(q.isEmpty()){
			   TreeNode node = q.remove();
			   if(isReverse) {
				   r.addFirst(node.val);
			   } else {
				   r.addLast(node.val);
			   }
			   if(null != node.left) {
				   nextQ.add(node.left);
			   }
			   if(null != node.right) {
					nextQ.add(node.right);
			   }
		   }
		   isReverse = !isReverse;
		   ret.add(r);
		   q = nextQ;
	   }
	   return ret;
   }
}