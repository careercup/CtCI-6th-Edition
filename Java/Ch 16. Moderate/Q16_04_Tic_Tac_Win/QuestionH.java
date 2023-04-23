package Q16_04_Tic_Tac_Win;

import java.util.ArrayList;

import CtCILibrary.AssortedMethods;

public class QuestionH {	
	public static Piece hasWon(Piece[][] board) {
		if (board.length != board[0].length) return Piece.Empty;
		int size = board.length;
		
		ArrayList<PositionIterator> instructions = new ArrayList<PositionIterator>();
		for (int i = 0; i < board.length; i++) {
			instructions.add(new PositionIterator(new Position(0, i), 1, 0, size));
			instructions.add(new PositionIterator(new Position(i, 0), 0, 1, size));
		}
		instructions.add(new PositionIterator(new Position(0, 0), 1, 1, size));
		instructions.add(new PositionIterator(new Position(0, size - 1), 1, -1, size));
		
		for (PositionIterator iterator : instructions) {
			Piece winner = hasWon(board, iterator);
			if (winner != Piece.Empty) {
				return winner;
			}
		}
		return Piece.Empty;
	}
	
	public static Piece hasWon(Piece[][] board, PositionIterator iterator) {
		Position firstPosition = iterator.next();
		Piece first = board[firstPosition.row][firstPosition.column];
		while (iterator.hasNext()) {
			Position position = iterator.next();
			if (board[position.row][position.column] != first) {
				return Piece.Empty;
			}
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
