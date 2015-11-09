'use strict';

export function isValidBST(tree) {
  if (!tree) {
    throw new Error('invalid tree');
  }
  return isValidBSTRecursive(tree.root, Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY);
}

function isValidBSTRecursive(node, min, max) {
  if (node) {
    if (node.val < min || node.val > max) {
      return false;
    }
    return isValidBSTRecursive(node.left, min, node.val) &&
      isValidBSTRecursive(node.right, node.val, max);
  }
  return true;
}
