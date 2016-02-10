package Q17_26_Sparse_Similarity;

import java.util.List;

public class Document {
	private List<Integer> words;
	private int docId;

	public Document(int id, List<Integer> w) {
		docId = id;
		words = w;
	}

	public List<Integer> getWords() {
		return words;
	}
	
	public int getId() {
		return docId;
	}
	
	public int size() {
		return words == null ? 0 : words.size();
	}
}
