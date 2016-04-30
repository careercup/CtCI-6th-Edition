package Q16_04_Tic_Tac_Win;

public class QuestionA {

	public static int convertBoardToInt(Piece[][] board) {
		int sum = 0;
		for (Piece[] pieces : board) {
			for (Piece piece : pieces) {
				int value = piece.ordinal();
				sum = sum * 3 + value;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Piece[][] board = { 
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Blue, Piece.Blue, Piece.Blue}};
		
		int v = convertBoardToInt(board);
		System.out.println(v);
	}

}
