'use strict';

/**
 * Travel through list and maintain two lists as we travel through. One list
 * contains all the items less than the partition value and the other contains
 * all the items greater than or equal to it.
 *
 * N = |list|
 * Time: O(N)
 * Additional space: O(1) -> as new structures aren't being created, original
 * list is being manipulated.
 */
export function partition(list, val) {
  let node = list,
    smallerHead, smallerTail, largerHead, largerTail;

  smallerHead = smallerTail = largerHead = largerTail = null;
  while (node) {
    let next = node.next;
    node.next = null;
    if (node.val >= val) {
      if (!largerTail) {
        largerHead = largerTail = node;
      }
      else {
        largerTail = largerTail.next = node;
      }
    }
    else if (node.val < val) {
      if (!smallerHead) {
        smallerHead = smallerTail = node;
      }
      else {
        smallerTail = smallerTail.next = node;
      }
    }
    node = next;
  }

  if (smallerTail) {
    smallerTail.next = largerHead;
  }
  return smallerHead || largerHead;
}
