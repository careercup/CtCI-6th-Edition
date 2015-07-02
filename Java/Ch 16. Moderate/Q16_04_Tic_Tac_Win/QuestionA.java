package Q16_04_Tic_Tac_Win;

public class QuestionA {

	public static int convertBoardToInt(Piece[][] board) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int value = board[i][j].ordinal();
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
