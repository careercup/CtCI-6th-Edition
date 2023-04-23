package Q16_04_Tic_Tac_Win;


import CtCILibrary.AssortedMethods;

public class QuestionB {	
	public static Piece hasWon(Piece[][] board, int row, int column) {
		if (board.length != board[0].length) return Piece.Empty;
		
		Piece piece = board[row][column];
		
		if (piece == Piece.Empty) return Piece.Empty;
		if (hasWonRow(board, row) || hasWonColumn(board, column)) {
			return piece;
		}
		
		if (row == column && hasWonDiagonal(board, 1)) {
			return piece;
		}
		
		if (row == (board.length - column - 1) && hasWonDiagonal(board, -1)) {
			return piece;
		}
		
		return Piece.Empty;
	}	
	
	public static boolean hasWonRow(Piece[][] board, int row) {
		for (int c = 1; c < board[row].length; c++) {
			if (board[row][c] != board[row][0]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasWonColumn(Piece[][] board, int column) {
		for (int r = 1; r < board.length; r++) {
			if (board[r][column] != board[0][column]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean hasWonDiagonal(Piece[][] board, int direction) {
		int row = 0;
		int column = direction == 1 ? 0 : board.length - 1;
		Piece first = board[0][column];
		for (int i = 0; i < board.length; i++) {
			if (board[row][column] != first) {
				return false;
			}
			row += 1;
			column += direction;
		}
		return true;
	}		
	
	public static void main(String[] args) {
		int N = 3;
		int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);

		board_t[1][1] = board_t[0][2];
		board_t[2][0] = board_t[0][2];
		
		Piece[][] board = new Piece[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int x = board_t[i][j];
				board[i][j] = Tester.convertIntToPiece(x);
			}
		}

		Piece p1 = hasWon(board, 0, 2);
		
		System.out.println(p1);
		AssortedMethods.printMatrix(board_t);
	}

}
