/**
 * Cracking the coding interview 1.8
 * Write a space efficient algorithm, such that if an element in MxN is 0, the entire row and column containing it are 0.
 *
 * Approach:
 * We can use a boolean matrix of MxN or a bit vector to mark row and columns to be nullified in first iteration, but it wont be space efficient.
 * More space efficient would be to first check first row and column and if any of them contains zero, mark them to be nullified using two boolearn vars
 * let's say firstRow and firstCol, and then iterate through rest of the matrix and store information in first row column elements, only when that row
 * and column is to be marked for nullified, this way we will only change values in first row and column which are already going to be 0 in final solution. 
 */

#include <iostream>

void nullifyRow( int ** matrix, int N, int row ) {
	for ( int j = 0; j < N; ++j ) {
		matrix[row][j] = 0;
	}
}

void nullifyCol( int ** matrix, int M, int col ) {
	for ( int i = 0; i < M; ++i ) {
		matrix[i][col] = 0;
	}
}


void nullifyMatrix( int ** matrix, int M, int N ) {
	bool firstRow = false;
	bool firstCol = false;

	//first row
	for( int i = 0; i < N; ++i ) {
		if ( matrix[0][i] == 0 ) {
			firstRow = true;
			break;
		}
	}

	//first col
	for ( int i = 0; i < M; ++i ) {
		if ( matrix[i][0] == 0 ) {
			firstCol = true;
			break;
		}
	}

	//rest of the matrix
	for( int i = 1; i < M; ++i ) {
		for ( int j = 1; j < N; ++j ) {
			if ( matrix[i][j] == 0 ) {
				matrix[i][0] = 0;
				matrix[0][j] = 0;
			}
		}
	}

	//now we know which row and column to be nullify using information stored in previous step.
	//rows first
	for ( int i = 1; i < M; ++i )  {
		if ( matrix[i][0]  == 0 ) {
			nullifyRow(matrix, N, i);
		}
	}

	//cols now
	for ( int j = 1; j < N; ++j ) {
		if ( matrix[0][j] == 0 ) {
			nullifyCol(matrix, M,  j);
		}
	}

	//now first row
	if ( firstRow ) {
		nullifyRow(matrix, N, 0);
	}

	//now first col
	if ( firstCol ) {
		nullifyCol(matrix, M, 0);
	}

}

void printMatrix( int ** matrix, int M, int N ) {
	for ( int i = 0; i < M; ++i ) {
		for ( int j = 0; j < N; ++j ) {
			std::cout << matrix[i][j] << "  ";
		}
		std::cout << std::endl;
	}
	std::cout << std::endl;
}


int main()
{
	int M, N;
	std::cout << "Enter number of rows:";
	std::cin >> M;
	std::cout << "Enter number of cols:";
	std::cin >> N;
	int ** matrix = new int*[M];
	for ( int i =0; i < M; ++i ) {
		matrix[i] = new int[N];
	}
	std::cout << "Provide M x N matrix \n";
	for ( int i = 0; i < M; ++i ) {
		for ( int j = 0; j < N; ++j ) {
			std::cin >> matrix[i][j];
		}
	}

	std::cout << "Matrix Before:\n";
	printMatrix(matrix, M, N);
	nullifyMatrix(matrix, M, N);
	std::cout << "Matrix After:\n";
	printMatrix(matrix, M, N);
	return 0;
}
