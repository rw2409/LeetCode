package wr.leetcode.algo.peeking_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


class PeekingIterator implements Iterator<Integer> {
    final Iterator<Integer> iterator;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        move();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = next;
        move();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (null != next);
    }

    private void  move() {
        if(iterator.hasNext()) {
            next = iterator.next();
        } else {
            //BUG: forgot to reset next if there is none
            next = null;
        }
    }



}

public class Solution {

    public static void main(String[] args) {

    }
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/*
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer buffer;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext()){
            buffer = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return buffer;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if( !hasNext() ){
            throw new NoSuchElementException("No more next!");
        }
        Integer ret = buffer;
        buffer = null;//VERY VERY EASY TO FORGET!!!
        if(iterator.hasNext()){
            buffer = iterator.next();
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (buffer != null);
    }
}

*/