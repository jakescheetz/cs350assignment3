import java.util.*;
import java.lang.*;

/*
 * Corner cases. Each static method should throw a java.lang.NullPointerException
 * if any of its arguments is null. You should assume that the argument array is 
 * in sorted order (with respect to the supplied comparator).
 * 
 * Performance requirements. The firstIndexOf()and lastIndexOf()methods should make
 * at most 1 + (log2N) compares in the worst case, where N is the length of the array. 
 * In this context, a compare is one call to comparator.compare().
 */

public class BinarySearchDeluxe {

  /* Returns the index of the first key in a[] that equals the search key, or -1 if no such key. 
   * assumes a sorted array 
   */
  public  static  <Key>  int  firstIndexOf(Term[]  a,  Term  key,  Comparator<Term> comparator) {
	  // if any of the arguments passed to firstIndexOf are null then this will throw java.lang.NullPointerException
	  if (a == null || key == null || comparator == null) throw new java.lang.NullPointerException();
	  // create instance variables 
	  int lo = 0; int hi = a.length - 1; int mid = lo + (hi - lo) / 2;;
	  // checks to see if the 0th index matches the key
	  if (comparator.compare(a[lo], key) == 0) { return 0; }
	  
	  // loop to find the first match
	  while (lo <= hi) {
		  mid = lo + (hi - lo) / 2;
		  if (lo == mid) {
			  return mid;
		  }
		  if (comparator.compare(key, a[mid]) < 0) {
			  hi = mid - 1;
		  } else if (comparator.compare(key, a[mid]) > 0) {
			  lo = mid + 1;
		  } else if (comparator.compare(a[mid - 1], a[mid]) == 0) {
			  hi = mid - 1;
		  } 
		  

	  }
	  
	  return -1;
  }
  
  /* Returns the index of the last key in a[] that equals the search key, or -1 if no such key. */
  public static <Key> int lastIndexOf(Term[] a, Term key, Comparator<Term> comparator) {
	  // if any of the arguments passed to firstIndexOf are null then this will throw java.lang.NullPointerException
	  if (a == null || key == null || comparator == null) throw new java.lang.NullPointerException();
	  // create instance variables 
	  int lo = 0; int hi = a.length - 1; int mid;
	  // checks to see if the last index matches the key
	  if (comparator.compare(a[hi], key) == 0) { return 0; }
	  
	  while (lo <= hi) {
		  mid = lo + (hi - lo) / 2;
		  
		  if (hi == mid) {
			  return mid;
		  }
		  
		  if (comparator.compare(key, a[mid]) < 0) {
			  hi = mid - 1;
		  } else if (comparator.compare(key, a[mid]) > 0) {
			  lo = mid + 1;
		  } else if (comparator.compare(a[mid + 1], a[mid]) == 0) {
			  hi = mid - 1;
		  } 

	  }
	  
	  return -1;
  }
}