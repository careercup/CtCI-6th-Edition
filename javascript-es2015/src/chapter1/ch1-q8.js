'use strict';
export default function zeroMatrix(matrix) {
  if (!matrix) {
    throw new Error('invalid matrix');
  }
  if (matrix.length === 0) {
    return matrix;
  }

  let rows = new Array(matrix.length),
    cols = new Array(matrix[0].length);

  rows.fill(false);
  cols.fill(false);

  for (let y = 0; y < rows.length; ++y) {
    for (let x = 0; x < cols.length; ++x) {
      if (matrix[y][x] === 0) {
        rows[y] = true;
        cols[x] = true;
      }
    }
  }

  for (let y = 0; y < rows.length; ++y) {
    for (let x = 0; x < cols.length; ++x) {
      if (rows[y] || cols[x]) {
        matrix[y][x] = 0;
      }
    }
  }

  return matrix;
}
