import java.util.*;
import java.lang.*;


public class Term implements Comparable<Term> {
	
	//instance variables 
	String query;
	long weight;
	
	
	/* Initializes a term with the given query string and weight */
	public Term(String query, long weight) {
		this.query = query;
		this.weight = weight;
		
		//exception handling
		if (this.query == null) {
			throw new java.lang.NullPointerException();
		}
		if (this.weight < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		
	}//end constructor 
	
	/* Compares the two terms in descending order by weight */
	public static Comparator<Term> byReverseWeightOrder(){
		return new ReverseWeightOrder();
	}//end byReverseWeightOrder
	
	/* defining a nested class for the reverse order */
	private static class ReverseWeightOrder implements Comparator <Term>{
		public int compare (Term q1, Term q2) {
			return q1.weight - q2.weight; //int used for ordering
		}
	}
	
	
	/* Compares the two terms in lexicographic order but using only the first
	r characters of each query. */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new java.lang.IllegalArgumentException(); //exception handling
		}
		
		
		
		
		
	}//end by PrefixOrder 
	
	/* compares the two terms in lexicographic order by query */
	public int compareTo(Term that) {
		/*if (this.query < that.query) {
			return -1;
		}
		if (this.query > that.query) {
			return 1;
		}*/
		int len_str1 = this.query.length();
		int len_str2 = that.query.length();
		int min;
		
		if (len_str1 < len_str2) {
			min = len_str1;
		} else {
			min = len_str2;
		}
		
		for (int i = 0; i < min; i++) {
			int str1 = (int) this.query.charAt(i); /* parse through the strings for comparison at each corresponding letter */ 
			int str2 = (int) that.query.charAt(i);
			
			if (str1 != str2) {
				return str1 - str2;
			}
		}//end for
		
		if (len_str1 != len_str2) {
			return len_str1 - len_str2;
		} else {
			return 0; //both the strings must be the same if this executes 
		}
		
	}//end compareTo
	
	/*
	 *  Returns a string representation of this term in the following format:
	 *  weight (i.e., ??.toString()), followed by a tab, followed by query.
	 *  
	 */
	public String toString() {
		return this.query;  //???????????????????????????????????????????
	}//end toString
	
	
}//end class Term





