package Q16_26_Calculator;

import java.util.ArrayList;

public class Term {	
	private double value;
	private Operator operator = Operator.BLANK;
	
	public Term(double v, Operator op) {
		value = v;
		operator = op;
	}
	
	public double getNumber() {
		return value;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setNumber(double v) {
		value = v;
	}
	
	public static ArrayList<Term> parseTermSequence(String sequence) {
		ArrayList<Term> terms = new ArrayList<Term>();
		int offset = 0;
		while (offset < sequence.length()) {
			Operator op = Operator.BLANK;
			if (offset > 0) {
				op = parseOperator(sequence.charAt(offset));
				if (op == Operator.BLANK) {
					return null;
				}
				offset++;
			}
			try {
				int value = parseNextNumber(sequence, offset);
				offset += Integer.toString(value).length();
				Term term = new Term(value, op);
				terms.add(term);
			} catch (NumberFormatException ex) {
				return null;
			}	
		}
		return terms;
	}
	
	public static Operator parseOperator(char op) {
		switch(op) {
		case '+': return Operator.ADD;
		case '-': return Operator.SUBTRACT;
		case '*': return Operator.MULTIPLY;
		case '/': return Operator.DIVIDE;
		}
		return Operator.BLANK;
	}
	
	public static int parseNextNumber(String sequence, int offset) {
		StringBuilder sb = new StringBuilder();
		while (offset < sequence.length() && Character.isDigit(sequence.charAt(offset))) {
			sb.append(sequence.charAt(offset));
			offset++;
		}
		return Integer.parseInt(sb.toString());	
	}
}
