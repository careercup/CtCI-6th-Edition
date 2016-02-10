'use strict';

/**
 * This algorithm simply stores each node it sees into a Set structure, if there
 * is a cycle then the first repeat we see will be the start of that cycle and
 * the value we should return.
 *
 * N = |list|
 * Time: O(N) - assumes Set is hashmap based so O(1) costs
 * Additional space: O(N)
 */
export function findStartOfLoopSet(list) {
  let visited = new Set(),
    node = list;

  while (node) {
    if (visited.has(node)) {
      return node;
    }
    visited.add(node);
    node = node.next;
  }

  return null;
}

/**
 * This algorithm uses the runners principle where we have a slow and fast (2x)
 * runners that both traverse the list. If at some point both runners point to
 * the same node then there is a cycle. Due to the different rate at which they
 * travel they will meet k steps 'before' the start of the cycle so if you reset
 * the slow runner back to the start and leave the faster runner at the meeting
 * point, when they start moving forward again they will eventually meet at the
 * start of the cycle.
 *
 * N = |list|
 * Time: O(N)
 * Additional space: O(1)
 */
export function findStartOfLoop(list) {
  if (!list) {
    return null;
  }

  let slow = list,
    fast = list;

  while (slow.next && fast.next && fast.next.next) {
    slow = slow.next;
    fast = fast.next.next;
    if (fast === slow) {
      break;
    }
  }

  if (!slow || slow !== fast) { // no loop
    return null;
  }

  slow = list;
  while (slow !== fast) {
    slow = slow.next;
    fast = fast.next;
  }

  return fast;
}
