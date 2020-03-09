// Client to return the first 'k' matching terms in the input file based on input
public class testclient {

	// args[0] is input file, args[1] is 'k'
	public static void main(String[] args) {
		String filename = args[0];
		In in = new In(filename);
		int N = in.readInt();
		Term[] terms = new Term[N];
		for (int i = 0; i < N; i++) {
			long weight = in.readLong();
			in.readChar();
			String query = in.readLine();
			terms[i] = new Term(query,weight);
		}
		

		int k = Integer.parseInt(args[1]);
		Autocomplete autocomplete = new Autocomplete(terms);
		while (StdIn.hasNextLine()) {
			String prefix = StdIn.readLine();
			Term[] results = autocomplete.allMatches(prefix);
			for (int i = 0; i < Math.min(k,  results.length); i++) {
				System.out.println(results[i]);
			}
		}
		
		
	}

}
