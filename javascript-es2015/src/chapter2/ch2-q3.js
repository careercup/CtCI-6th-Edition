'use strict';

/**
 * Copy the value from the next node into the current node object and then
 * update the next pointer of the current object to skip over the next node.
 *
 * Time: O(1)
 * Additional space: O(1)
 */
export function deleteMiddleNode(node) {
  if (!node || !node.next) {
    throw new Error('invalid node');
  }

  node.val = node.next.val;
  node.next = node.next.next;
}
