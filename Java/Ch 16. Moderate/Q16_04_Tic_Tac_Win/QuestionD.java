package Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

public class QuestionD {
	public static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
		if (p1 == Piece.Empty) {
			return false;
		}
		return p1 == p2 && p2 == p3;
	}
	
	public static Piece hasWon(Piece[][] board) {
		if (board[0][0] != Piece.Empty &&
			(hasWinner(board[0][0], board[0][1], board[0][2]) ||
			 hasWinner(board[0][0], board[1][0], board[2][0]))) {
			return board[0][0];
		}
		
		if (board[2][2] != Piece.Empty &&
			(hasWinner(board[2][0], board[2][1], board[2][2]) ||
			 hasWinner(board[0][2], board[1][2], board[2][2]))) {
			return board[2][2];
		}
		
		if (board[1][1] != Piece.Empty &&
			(hasWinner(board[0][0], board[1][1], board[2][2]) ||
			 hasWinner(board[0][2], board[1][1], board[2][0]) ||
			 hasWinner(board[1][0], board[1][1], board[1][2]) ||
			 hasWinner(board[0][1], board[1][1], board[2][1]))) {
			return board[1][1];
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
