package Q16_04_Tic_Tac_Win;

import CtCILibrary.AssortedMethods;

public class Tester {	
	public static Piece convertIntToPiece(int i) {
		if (i == 1) {
			return Piece.Blue;
		} else if (i == 2) {
			return Piece.Red;
		} else {
			return Piece.Empty;
		}
	}
	

	
	
	public static Piece hasWonB(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				Piece winner =QuestionB.hasWon(board, i, j);
				if (winner != Piece.Empty) {
					return winner;
				}
			}
		}
		return Piece.Empty;
	}
	
	public static void main(String[] args) {
		for (int k = 0; k < 100; k++) {
			int N = 3;
			int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
			Piece[][] board = new Piece[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int x = board_t[i][j];
					board[i][j] = convertIntToPiece(x);
				}
			}
			//AssortedMethods.printMatrix(board_t);
			Piece p1 = hasWonB(board);
			Piece p2 = QuestionC.hasWon(board);
			Piece p3 = QuestionD.hasWon(board);
			Piece p4 = QuestionE.hasWon(board);
			Piece p5 = QuestionF.hasWon(board);
			Piece p6 = QuestionG.hasWon(board);
			Piece p7 = QuestionH.hasWon(board);
			//System.out.println(p + " " + p2);
			if (p1 != p2 || p2 != p3 || p3 != p4 || p4 != p5 || p5 != p6 || p6 != p7) {
				System.out.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7);
				AssortedMethods.printMatrix(board_t);
			}
		}
		
		for (int k = 0; k < 100; k++) {
			int N = 4;
			int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
			Piece[][] board = new Piece[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int x = board_t[i][j];
					board[i][j] = convertIntToPiece(x);
				}
			}
			//AssortedMethods.printMatrix(board_t);
			Piece p3 = hasWonB(board);
			Piece p4 = QuestionE.hasWon(board);
			Piece p5 = QuestionF.hasWon(board);
			Piece p6 = QuestionG.hasWon(board);
			Piece p7 = QuestionH.hasWon(board);
			//System.out.println(p + " " + p2);
			if (p3 != p4 || p4 != p5 || p5 != p6 || p6 != p7) {
				System.out.println(p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7);
				AssortedMethods.printMatrix(board_t);
			}
		}		
	}

}
