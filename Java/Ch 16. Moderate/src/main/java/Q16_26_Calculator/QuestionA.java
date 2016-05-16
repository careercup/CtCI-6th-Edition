package Q16_26_Calculator;

import java.util.ArrayList;

public class QuestionA {
	public static Term collapseTerm(Term primary, Term secondary) {
		if (primary == null) return secondary;
		if (secondary == null) return primary;
		
		double value = applyOp(primary.getNumber(), secondary.getOperator(), secondary.getNumber());
		primary.setNumber(value);
		return primary;
	}
	
	public static double applyOp(double left, Operator op, double right) {
		if (op == Operator.ADD) {
			return left + right;
		} else if (op == Operator.SUBTRACT) {
			return left - right;
		} else if (op == Operator.MULTIPLY) {
			return left * right;
		} else if (op == Operator.DIVIDE) {
			return left / right;
		} else {
			return right;
		}
	}
	
	/* Compute the result of the arithmetic sequence. This
	   works by reading left to right and applying each term to
	   a result. When we see a multiplication or division, we 
	   instead apply this sequence to a temporary variable. */
	public static double compute(String sequence) {
		ArrayList<Term> terms = Term.parseTermSequence(sequence);
		if (terms == null) return Integer.MIN_VALUE;
		
		double result = 0;
		Term processing = null;
		for (int i = 0; i < terms.size(); i++) {
			Term current = terms.get(i);
			Term next = i + 1 < terms.size() ? terms.get(i + 1) : null;
			
			/* Apply the current term to “processing”. */
			processing = collapseTerm(processing, current);
			
			/* If next term is + or -, then this cluster is done 
			 * and we should apply “processing” to “result”. */
			if (next == null || next.getOperator() == Operator.ADD || next.getOperator() == Operator.SUBTRACT) {
				result = applyOp(result, processing.getOperator(), processing.getNumber());
				processing = null;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String expression = "6/5*3+4*5/2-12/6*3/3+3+3";
		double result = compute(expression);
		System.out.println(result);		
	}

}
