/**
 * [removeDuplicatesSet description]
 * @param  {[type]} list [description]
 * @return {[type]}      [description]
 */
export function removeDuplicatesSet(list) {
  if (!list) {
    return list;
  }

  let seen = new Set(),
    node = list;

  // add head
  seen.add(node.val);
  while (node.next) {
    if (seen.has(node.next.val)) {
      // skip next node
      node.next = node.next.next;
    }
    else {
      seen.add(node.next.val);
      node = node.next;
    }
  }

  return list; // return list, head will never change
}
