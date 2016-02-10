'use strict';

import { Tree } from './helpers';

/**
 * As the list is already sorted the best way to create a balanced tree is by
 * adding the middle node (parent) then the children. The algorithm is basically
 * involves adding the middle element of which split of the array so that the
 * parent is added before the left and right children of each subtree.
 *
 * N = |values|
 * Time: O(N lg N)
 * Additional space: O(N)
 */
export function makeBalancedTree(values) {
  let tree = new Tree();
  if (values && values.length) {
    add(tree, values, 0, values.length - 1);
  }
  return tree;
}

function add(tree, values, start, end) {
  if (start === end) {
    tree.add(values[start]);
  }
  else if (start < end) {
    let mid = start + Math.floor((end - start) / 2);
    tree.add(values[mid]);
    add(tree, values, start, mid - 1);
    add(tree, values, mid + 1, end);
  }
}
