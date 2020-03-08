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
	
	
	
	/* Compares the two terms in lexicographic order but using only the first
	r characters of each query. */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new java.lang.IllegalArgumentException(); //exception handling
		}
		return new PrefixOrder();
	}//end by PrefixOrder 
	
	/* compares the two terms in lexicographic order by query */
	public int compareTo(Term that) {
		return this.query.compareTo(that.query);
	}//end compareTo
	
	/*
	 *  Returns a string representation of this term in the following format:
	 *  weight (i.e., ??.toString()), followed by a tab, followed by query.
	 *  
	 */
	public String toString() {
		return this.query + "\t" + query;
	}//end toString
	
	
}//end class Term

private static class ReverseWeightOrder implements Comparator<Term>{ /* nested class for reverse weight order */
	public int compare(Term x, Term y) {
		if (x.weight > y.weight) {
			return -1;
		}
		else if (x.weight == y.weight) {
			return 0;
		}
		else {
			return 1; // x.weight < y.weight
		}
	}//end compare
	
	
}//end ReverseWeightOrder 

private static class PrefixOrder implements Comparator<Term>{ /* nested class for prefix order */
	private int x;
	
	private PrefixOrder(int y){
		this.y = y;
	}
	
	public int compare(Term q1, Term q2) {
		String s1;
		String s2;
		if (q1.query.length() < x) {
			s1 = q1.query;
		} else {
			s1 = q1.query.substring(0, x);
		}
		
		if (q2.query.length() < x) {
			s2 = q2.query;
		} else {
			s2 = q2.query.substring(0, x);
		}
		
		return s1.compareTo(s2);
	}
	
}//end PrefixOrder class 





