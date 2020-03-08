
public class Autocomplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

public class Merge{ //for running time (n log n)
	
	//sort for merge sort, recursively 
	private static void sort (Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}//end sort
	
	//merge for merge sort, runtime n log n
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k < = hi; k++) {
			if (i > mid) {
				break;
			}
			else if (j > hi) {
				a[k] = aux[i++];
			}
			else if (less(aux[j], aux[i])) {
				a[k] = a[j++];
			}
			else {
				a[k] = aux[i++]
			}
		}
		
	}//end merge method 
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
}//end merge class 

