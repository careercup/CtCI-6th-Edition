package Q17_26_Sparse_Similarity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import CtCILibrary.AssortedMethods;

public class QuestionA {
	public static HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents) {
		ArrayList<Document> docs = new ArrayList<Document>();
		for (Document doc : documents.values()) {
			docs.add(doc);
		}
		return computeSimilarities(docs);
	}
	
	public static HashMap<DocPair, Double> computeSimilarities(ArrayList<Document> documents) {
		HashMap<DocPair, Double> similarities = new HashMap<DocPair, Double>();
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
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.addAll(doc1.getWords());
		
		for (int word : doc2.getWords()) {
			if (set1.contains(word)) {
				intersection++;
			}
		}
		
		double union = doc1.size() + doc2.size() - intersection;
		
		return intersection / union;
	}	
	
	public static ArrayList<Integer> removeDups(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int a : array) {
			set.add(a);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		return list;
	}
	
	public static void main(String[] args) {
		int numDocuments = 10;
		int docSize = 5;
		HashMap<Integer, Document> documents = new HashMap<Integer, Document>();
		for (int i = 0; i < numDocuments; i++) {
			int[] words = AssortedMethods.randomArray(docSize, 0, 10);
			ArrayList<Integer> w = Tester.removeDups(words);
			System.out.println(i + ": " + w.toString());
			Document doc = new Document(i, w);
			documents.put(i, doc);
		}
		
		HashMap<DocPair, Double> similarities = computeSimilarities(documents);
		Tester.printSim(similarities);
	}

}
