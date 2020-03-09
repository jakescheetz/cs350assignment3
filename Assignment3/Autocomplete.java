import java.util.Arrays;

// implement sorting algorithm in this class
public class Autocomplete {
	
	Term[] terms;
	

	// initializes the data structure from the given array of terms.
	public Autocomplete(Term[] terms) {
		//creates copy of term array to be sorted
		this.terms = new Term[terms.length]; 
		for (int i = 0; i < terms.length; i++) {
			this.terms[i]=terms[i];
		}
		
		// Lexicographic sort
		Arrays.sort(this.terms, Term.byPrefixOrder(3));
		
	}
	
	
	
	// returns all terms that start with the given prefix, in descending order by weight.
	public Term[] allMatches(String prefix) {
		
		
		// Exception for null prefix
		if (prefix==null) throw new java.lang.NullPointerException();
		
		// Find first and last index of matching terms with query (binary search)
		int first_match = BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 5), Term.byPrefixOrder(prefix.length()));
		// Return if no matches are found
		if (first_match == -1) return new Term[0];
		int last_match = BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 5), Term.byPrefixOrder(prefix.length()));
		
		// New array of matching terms

		Term[] termArray = new Term[last_match-first_match+1];
		for (int k = 0; k < termArray.length; k++) {
			termArray[k] = terms[first_match+k];
		}
		
	
		// Return list of matching terms in descending order by weight (sort)
		Arrays.sort(termArray, Term.byReverseWeightOrder());

		
		return termArray;
	}



//public class Merge{ //for running time (n log n)
//	
//	//sort for merge sort, recursively 
//	public static void sort (Comparable[] a, Comparable[] aux, int lo, int hi) {
//		if (hi <= lo) {
//			return;
//		}
//		int mid = lo + (hi - lo) / 2;
//		sort(a, aux, lo, mid);
//		sort(a, aux, mid+1, hi);
//		merge(a, aux, lo, mid, hi);
//	}//end sort
//	
//	//merge for merge sort, runtime n log n
//	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//		for (k = lo; k <= hi; k++) {
//			aux[k] = a[k];
//		}
//		int i = lo, j = mid + 1;
//		for (int k = lo; k < = hi; k++) {
//			if (i > mid) {
//				break;
//			}
//			else if (j > hi) {
//				a[k] = aux[i++];
//			}
//			else if (less(aux[j], aux[i])) {
//				a[k] = a[j++];
//			}
//			else {
//				a[k] = aux[i++]
//			}
//		}
//		
//	}//end merge method 
//	
//	private static boolean less(Comparable v, Comparable w) {
//		return v.compareTo(w) < 0;
//	}
//	
//}//end merge class 

}
