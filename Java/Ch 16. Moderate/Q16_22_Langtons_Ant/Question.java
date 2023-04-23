package Q16_22_Langtons_Ant;

public class Question {

	public static void main(String[] args) {
		Board board = new Board();
		Grid grid = new Grid();
		System.out.println(board.toString());
		for (int i = 0; i < 100; i++) {
			System.out.println("\n\n---- MOVE " + i + " ----");
			board.move();
			String bs = board.toString();
			System.out.println(bs);
			
			grid.move();
			String gs = grid.toString();
			System.out.println(gs);
			
			boolean equals = bs.equals(gs);
			System.out.println(equals);
			
			if (!equals) {
				break;
			}
		}
	}
}
