'use strict';

/**
 * This function attempts to check if the tree is completely balanced by finding
 * the shortest and longest paths from root to leaf. If the difference between
 * these two paths is greater than 1 then the tree is not balanced.
 *
 * N = |tree|
 * Time: O(N)
 * Additional space: O(lg N) - space cost is due to call stack size while using
 * recursion, this may be O(N) in the worst case.
 */
export function isBalanced(tree) {
  if (!tree || !tree.root) {
    return true;
  }

  let node = tree.root,
    cache = {
      min: Number.MAX_SAFE_INTEGER,
      max: Number.MIN_SAFE_INTEGER
    };

  findDepth(cache, node, 0);
  return cache.max - cache.min <= 1;
}

function findDepth(cache, node, depth) {
  if (!node) {
    if (depth < cache.min) {
      cache.min = depth;
    }
    if (depth > cache.max) {
      cache.max = depth;
    }
  } else {
    findDepth(cache, node.left, depth + 1);
    findDepth(cache, node.right, depth + 1);
  }
}
