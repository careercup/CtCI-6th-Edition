
export function linkedListToArray(list) {
  let arr = [],
    node = list;

  while (node !== null) {
    arr.push(node.val);
    node = node.next;
  }

  return arr;
}

export function createNode(val, next) {
  return {
    val: val,
    next: next || null
  };
}

export function arrayToLinkedList(arr) {
  if (arr.length === 0) {
    return null;
  }

  let list = null;
  for (let i = arr.length - 1; i >= 0; --i) {
    list = createNode(arr[i], list);
  }

  return list;
}
