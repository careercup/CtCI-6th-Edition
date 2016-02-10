'use strict';

/**
 * To check if tree2 is a subtree of tree1 this algorithm basically searches
 * through tree1 looking for a potential root node (a node whose value matches
 * the root node of tree2). Once found go through node for node comparing from
 * that found root down to the nodes in tree2. If they all match then tree2 is
 * a subtree.
 *
 * N = |tree1|
 * M = |tree2|
 * Time: O(NM)
 * Additional space: O(lg N) - space cost is due to recursive nature of algorithm
 * and assumes a balanced tree, worst case is O(N)
 */
export function isSubtree(tree1, tree2) {
  if (!tree1 || !tree1.root) {
    throw new Error('trees1 must be valid non-empty trees');
  }
  if (!tree2 || !tree2.root) {
    return true;
  }
  return findRoot(tree1.root, tree2.root);
}

function findRoot(node1, node2) {
  if (!node1 || !node2) {
    return false;
  }
  else if (node1.val === node2.val && sameTree(node1, node2)) {
    return true;
  }
  else {
    return findRoot(node1.left, node2) || findRoot(node1.right, node2);
  }
}

function sameTree(node1, node2) {
  if (!node1 && !node2) {
    return true;
  }
  else if (!node1 && node2 || node1 && !node2) {
    return false;
  }
  else if (node1.val === node2.val) {
    return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
  }
  else {
    return false;
  }
}
