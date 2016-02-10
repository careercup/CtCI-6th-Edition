'use strict';

import { getLength } from './helpers';

/**
 * Walk one pointer ahead k nodes first then create a second pointer to the
 * start of the list. Walk both pointers until the first one hits the end of the
 * list, at that point the second pointer will be pointing to the kth to last
 * node.
 *
 * N = |list|
 * Time: O(N)
 * Additional space: O(1)
 */
export function kthToLastTwoPointers(list, k) {
  if (!list) {
    throw new Error('invalid list');
  }

  let last = list,
    kth = list;

  for (let i = 0; i < k; ++i) {
    last = last.next;
    if (!last) {
      throw new Error('list is not long enough');
    }
  }

  while (last.next) {
    last = last.next;
    kth = kth.next;
  }

  return kth.val;
}

/**
 * Determine the length of the input list. Subtract k from the calculated length
 * and skip that many nodes from the start of the list. That node is the kth to
 * last.
 *
 * N = |list|
 * Time: O(N)
 * Additional space: O(1)
 */
export function kthToLastLength(list, k) {
  if (!list) {
    throw new Error('invalid list');
  }

  let len = getLength(list),
    skip = len - k,
    node = list;

  if (skip <= 0) {
    throw new Error('list is not long enough');
  }

  for (let i = 1; i < skip; ++i) {
    node = node.next;
  }

  return node.val;
}
