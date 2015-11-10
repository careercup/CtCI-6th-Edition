'use strict';

import { getLength } from './helpers';

/**
 * Find out the length of the two lists first. If they intersect at some point
 * then the length of their tails will be the same and any difference in length
 * must be from before they intersect. If the lists are different lengths then
 * skip the difference in the longer list. Walk through both lists in step until
 * a node that is the same in both lists is found or the end of one of the lists
 * is reached.
 *
 * N = max(|list1|, |list2|)
 * Time: O(N)
 * Additional space: O(1)
 */
export function doIntersect(list1, list2) {
  let len1 = getLength(list1),
    len2 = getLength(list2);

  list1 = skip(list1, len1 - len2);
  list2 = skip(list2, len2 - len1);

  let node1 = list1,
    node2 = list2;
  while (node1 && node2) {
    if (node1 === node2) {
      return node1;
    }
    node1 = node1.next;
    node2 = node2.next;
  }

  return undefined;
}

function skip(list, num) {
  while (num > 0) {
    list = list.next;
    --num;
  }
  return list;
}
