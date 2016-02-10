'use strict';

/**
 * Go through the matrix diagonally from 0,0 until half way through (one less
 * where odd N). For each diagonal starting point move through matrix along row
 * until length - starting index. For each index in the matrix go through all 4
 * sides moving items along one place.
 *
 * N = dimension of matrix
 * Time: O(N^2)
 * Additional space: O(1)
 *
 * @param  {array} matrix NxN matrix to rotate in place
 * @return {array}        Rotated matrix, same object as input
 */
export function rotateMatrix(matrix) {
  if (!matrix || matrix.length === 0 || matrix.length !== matrix[0].length) {
    throw new Error('invalid matrix');
  }
  if (matrix.length < 2) {
    return matrix; // no need to do anything to rotate a 1,1 matrix
  }

  let len = matrix.length - 1,
    half = Math.floor(matrix.length / 2);
  // loop through diagonal
  for (let start = 0; start < half; ++start) {

    // loop through x axis
    for (let i = 0; i < len - (start * 2); ++i) {
      let y = start,
        x = start + i,
        prev = matrix[y][x];

      // loop through all 4 corners
      for (let j = 0; j < 4; ++j) {
        let nextY = x,
          nextX = len - y,
          next = matrix[nextY][nextX];
        matrix[nextY][nextX] = prev;
        prev = next;
        x = nextX;
        y = nextY;
      }
    }
  }

  return matrix;
}
