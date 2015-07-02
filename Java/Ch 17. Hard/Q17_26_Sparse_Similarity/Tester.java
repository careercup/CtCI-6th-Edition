package Q17_26_Sparse_Similarity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Tester {
	public static ArrayList<Integer> removeDups(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int a : array) {
			set.add(a);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		return list;
	}
	
	public static boolean isEqual(HashMap<DocPair, Double> one, HashMap<DocPair, Double> two) {
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
	
	public static void printSim(HashMap<DocPair, Double> similarities) {
		for (Entry<DocPair, Double> result : similarities.entrySet()) {
			DocPair pair = result.getKey();
			Double sim = result.getValue();
			System.out.println(pair.doc1 + ", " + pair.doc2 + " : " + sim);
		}
	}
	
	public static void addTo(HashMap<Integer, Document> documents, int id, int[] array) {
		ArrayList<Integer> w = removeDups(array);
		Document doc = new Document(id, w);
		documents.put(id, doc);
	}
	
	public static void main(String[] args) {
		/*int numDocuments = 5;
		int docSize = 5;
		HashMap<Integer, Document> documents = new HashMap<Integer, Document>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			ArrayList<Integer> w = removeDups(words);
			System.out.println(i + ": " + w.toString());
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}*/
		HashMap<Integer, Document> documents = new HashMap<Integer, Document>();
		
		int[] array1 = {14, 15, 100, 9, 3};
		addTo(documents, 13, array1);

		int[] array2 = {32, 1, 9, 3, 5};
		addTo(documents, 16, array2);

		int[] array3 = {15, 29, 2, 6, 8, 7};
		addTo(documents, 19, array3);

		int[] array4 = {7, 10};
		addTo(documents, 24, array4);
		
		
		HashMap<DocPair, Double> simA = QuestionA.computeSimilarities(documents);
		HashMap<DocPair, Double> simB = QuestionB.computeSimilarities(documents);
		HashMap<DocPair, Double> simC = QuestionC.computeSimilarities(documents);
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
