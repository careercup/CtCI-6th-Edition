package Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

public class QuestionE {

	public static Piece hasWon(Piece[][] board) {
		int size = board.length;
		if (board[0].length != size) return Piece.Empty;
		Piece first;
		
		/* Check rows. */
		for (int i = 0; i < size; i++) {
			first = board[i][0];
			if (first == Piece.Empty) continue;
			for (int j = 1; j < size; j++) {
				if (board[i][j] != first) {
					break;
				} else if (j == size - 1) {
					return first;
				}
			}
		}
		
		/* Check columns. */
		for (int i = 0; i < size; i++) {
			first = board[0][i];
			if (first == Piece.Empty) continue;
			for (int j = 1; j < size; j++) {
				if (board[j][i] != first) {
					break;
				} else if (j == size - 1) {
					return first;
				}
			}
		}
		
		/* Check diagonals. */
		first = board[0][0];
		if (first != Piece.Empty) {
			for (int i = 1; i < size; i++) {
				if (board[i][i] != first) {
					break;
				} else if (i == size - 1) {
					return first;
				}
			}
		}
		
		first = board[0][size - 1];
		if (first != Piece.Empty) {
			for (int i = 1; i < size; i++) {
				if (board[i][size - i - 1] != first) {
					break;
				} else if (i == size - 1) {
					return first;
				}
			}
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
