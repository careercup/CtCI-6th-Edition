'use strict';
import { Tree } from './helpers';

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

export function makeBalancedTree(values) {
  let tree = new Tree();
  if (values && values.length) {
    add(tree, values, 0, values.length - 1);
  }
  return tree;
}
