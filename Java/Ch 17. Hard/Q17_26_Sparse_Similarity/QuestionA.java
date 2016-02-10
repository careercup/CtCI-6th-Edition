package Q17_26_Sparse_Similarity;

import CtCILibrary.AssortedMethods;

import java.util.*;

public class QuestionA {
	public static Map<DocPair, Double> computeSimilarities(Map<Integer, Document> documents) {
		List<Document> docs = new ArrayList<>();
		for (Document doc : documents.values()) {
			docs.add(doc);
		}
		return computeSimilarities(docs);
	}

	public static Map<DocPair, Double> computeSimilarities(List<Document> documents) {
		Map<DocPair, Double> similarities = new HashMap<>();
		for (int i = 0; i < documents.size(); i++) {
			for (int j = i + 1; j < documents.size(); j++) {
				Document doc1 = documents.get(i);
				Document doc2 = documents.get(j);
				double sim = computeSimilarity(doc1, doc2);
				if (sim > 0) {
					DocPair pair = new DocPair(doc1.getId(), doc2.getId());
					similarities.put(pair, sim);
				}
			}
		}
		return similarities;
	}
		
	public static double computeSimilarity(Document doc1, Document doc2) {
		int intersection = 0;
		Set<Integer> set1 = new HashSet<>();
		set1.addAll(doc1.getWords());
		
		for (int word : doc2.getWords()) {
			if (set1.contains(word)) {
				intersection++;
			}
		}
		
		double union = doc1.size() + doc2.size() - intersection;
		
		return intersection / union;
	}

	public static List<Integer> removeDups(int[] array) {
		Set<Integer> set = new HashSet<>();
		for (int a : array) {
			set.add(a);
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}
	
	public static void main(String[] args) {
		int numDocuments = 10;
		int docSize = 5;
		Map<Integer, Document> documents = new HashMap<>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			List<Integer> w = Tester.removeDups(words);
			System.out.println(i + ": " + w);
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}

		Map<DocPair, Double> similarities = computeSimilarities(documents);
		Tester.printSim(similarities);
	}

}
