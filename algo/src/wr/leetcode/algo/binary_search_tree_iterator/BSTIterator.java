package wr.leetcode.algo.binary_search_tree_iterator;

import wr.leetcode.algo.TreeNode;

import java.util.Stack;



public class BSTIterator {

    //stack is stack, not list
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeftDecents(root);
    }

    private void pushLeftDecents( TreeNode node){
        while(node != null) {
          stack.push(node);
          node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        return nextNode().val;
    }

    public TreeNode nextNode() {
        if(!hasNext()){
            throw new RuntimeException("Index out of bound!");
        }
        TreeNode node = stack.pop();
        pushLeftDecents(node.right);
        return node;
    }
}

