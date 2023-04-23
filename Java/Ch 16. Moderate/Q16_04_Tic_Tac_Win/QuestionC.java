package Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

public class QuestionC {
	public static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
		if (p1 == Piece.Empty) {
			return false;
		}
		return p1 == p2 && p2 == p3;
	}
	
	public static Piece hasWon(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			/* Check Rows */
			if (hasWinner(board[i][0], board[i][1], board[i][2])) {
				return board[i][0];
			}

			/* Check Columns */
			if (hasWinner(board[0][i], board[1][i], board[2][i])) {
				return board[0][i];
			}
		}

		/* Check Diagonal */
		if (hasWinner(board[0][0], board[1][1], board[2][2])) {
			return board[0][0];
		}
		
		if (hasWinner(board[0][2], board[1][1], board[2][0])) {
			return board[0][2];
		}
		
		return Piece.Empty;
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
