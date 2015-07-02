package Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

public class QuestionF {

	public static Piece hasWon(Piece[][] board) {
		Piece winner = Piece.Empty;
		
		/* Check rows. */
		for (int i = 0; i < board.length; i++) {
			winner = hasWon(board, i, 0, 0, 1);
			if (winner != Piece.Empty) {
				return winner;
			}
		}
		
		/* Check columns. */
		for (int i = 0; i < board[0].length; i++) {
			winner = hasWon(board, 0, i, 1, 0);
			if (winner != Piece.Empty) {
				return winner;
			}
		}
		
		/* Check top/left -> bottom/right diagonal. */
		winner = hasWon(board, 0, 0, 1, 1);
		if (winner != Piece.Empty) {
			return winner;
		}
		
		/* Check top/right -> bottom/left diagonal. */
		return hasWon(board, 0, board[0].length - 1, 1, -1);
	}
	
	public static Piece hasWon(Piece[][] board, int row, int col, int incrementRow, int incrementCol) {
		Piece first = board[row][col];
		while (row < board.length && col < board[row].length) {
			if (board[row][col] != first) {
				return Piece.Empty;
			}
			row += incrementRow;
			col += incrementCol;
		}
		return first;
	}
	
	public static void main(String[] args) {
		int N = 3;
		int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
		Piece[][] board = new Piece[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = board_t[i][j];
				board[i][j] = Tester.convertIntToPiece(x);
			}
		}

		Piece p1 = hasWon(board);
		
		System.out.println(p1);
		AssortedMethods.printMatrix(board_t);
	}

}
