/*
 *
 * Names: Jacob Scheetz, Ian Iding, Bailey Dauterman (scheetzj2, idingi1, dautermanb1)
 * 
 * Assignment: assignment3 - autocomplete
 * 
 * Description: use of searching and sorting algorithms to create a autocomplete search bar. This also utilized nested classes and generics. 
 * 
 * Bug Report: Program occasionally has trouble with sorting algorithm when spaces are read from the line. The program can only take one input at a time. 
 *
 */

import java.util.*;
import java.lang.*;

public class BinarySearchDeluxe {

    /* Corner cases. Each static method should throw a java.lang.NullPointerExceptionif any of its arguments is null. 
     * You should assume that the argument array is in sorted order (with respect to the supplied comparator). 
     *
     * Performance requirements. The firstIndexOf()and lastIndexOf()methods should make at most 1 + ⌈log2N⌉compares in the worst case, 
     * where Nis the length of the array. In this context, a compareis one call to comparator.compare().
	*/

    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if (a == null || key == null || comparator == null) throw new java.lang.NullPointerException(); // per corner cases

    	int lo = 0; int hi = a.length - 1; int mid;
    	
        // checks for best case scenario of the first key being the correct index
        if (comparator.compare(a[lo], key) == 0) { 
            return 0; 
        }
    	while (lo <= hi) {
            // set mid to the middle of hi and lo
    		mid = lo + (hi - lo) / 2;

    		if (comparator.compare(key, a[mid]) < 0) {// check if the key is less than the current mid index
                // set hi to the mid index - 1 because we don't need anything after that
                hi = mid - 1;
            } else if (comparator.compare(key, a[mid]) > 0) {// check if the key is greater than the current mid index
                // set lo to the mid index + 1 because everything before the mid point is useless
                lo = mid + 1;
            } else if (comparator.compare(a[mid - 1], a[mid]) == 0) {// check if the index right before the mid index is the correct answer
                // sets the hi index to the mid index - 1 becayse every index after the mid index is now useless
                hi = mid - 1;
            } else {// if it gets this far the mid index is the correct index
                return mid;
            }
    	}
		return -1;
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	if (a == null || key == null || comparator == null) throw new java.lang.NullPointerException(); // per corner case

    	int lo = 0; int hi = a.length - 1; int mid;

        // checks for best case scenario of the last index being the correct index
    	if (comparator.compare(a[hi], key) == 0) {
            return hi;
        }

        /* this while loop functions a similarly to the firstIndexOf, with an exception to the change
         * of the second else if statement, this now checks for the mid index + 1 instead of mid - 1.
         * this occurs because we are looking for the last index of the key, so if mid and mid + 1 are
         * the same we will return the highest index.
         */
    	while (lo <= hi) {
    		mid = lo + (hi - lo) / 2;
    		if (comparator.compare(key, a[mid]) < 0) {
                hi = mid - 1;
            } else if (comparator.compare(key, a[mid]) > 0) {
                lo = mid + 1;
            } else if (comparator.compare(a[mid + 1], a[mid]) == 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
    	}
		return -1;
    }
}
