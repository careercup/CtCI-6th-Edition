package Q17_26_Sparse_Similarity;

import java.util.*;
import java.util.Map.Entry;

public class Tester {
	public static List<Integer> removeDups(int[] array) {
		Set<Integer> set = new HashSet<>();
		for (int a : array) {
			set.add(a);
		}
		List<Integer> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}

	public static boolean isEqual(Map<DocPair, Double> one, Map<DocPair, Double> two) {
		if (one.size() != two.size()) {
			return false;
		}
		
		for (Entry<DocPair, Double> a : one.entrySet()) {
			if (!two.containsKey(a.getKey())) {
				return false;
			}
			double sim1 = a.getValue();
			double sim2 = two.get(a.getKey());
			if (sim1 != sim2) {
				return false;
			}
		}
		return true;
	}

	public static void printSim(Map<DocPair, Double> similarities) {
		for (Entry<DocPair, Double> result : similarities.entrySet()) {
			DocPair pair = result.getKey();
			Double sim = result.getValue();
			System.out.println(pair.doc1 + ", " + pair.doc2 + " : " + sim);
		}
	}

	public static void addTo(Map<Integer, Document> documents, int id, int[] array) {
		List<Integer> w = removeDups(array);
		Document doc = new Document(id, w);
		documents.put(id, doc);
	}
	
	public static void main(String[] args) {
		/*int numDocuments = 5;
		int docSize = 5;
		Map<Integer, Document> documents = new HashMap<Integer, Document>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			List<Integer> w = removeDups(words);
			System.out.println(i + ": " + w.toString());
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}*/
		Map<Integer, Document> documents = new HashMap<>();
		
		int[] array1 = {14, 15, 100, 9, 3};
		addTo(documents, 13, array1);

		int[] array2 = {32, 1, 9, 3, 5};
		addTo(documents, 16, array2);

		int[] array3 = {15, 29, 2, 6, 8, 7};
		addTo(documents, 19, array3);

		int[] array4 = {7, 10};
		addTo(documents, 24, array4);

		Map<DocPair, Double> simA = QuestionA.computeSimilarities(documents);
		Map<DocPair, Double> simB = QuestionB.computeSimilarities(documents);
		Map<DocPair, Double> simC = QuestionC.computeSimilarities(documents);
		System.out.println("----------");
		printSim(simA);
		System.out.println("----------");
		printSim(simB);
		System.out.println("----------");
		printSim(simC);
		System.out.println("----------");
		
		System.out.println(isEqual(simA, simB));
		System.out.println(isEqual(simB, simC));
		System.out.println(isEqual(simA, simC));
	}

}
