'use strict';

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

export function getLength(list) {
  let length = 0;
  while (list) {
    list = list.next;
    ++length;
  }
  return length;
}

export function createLinkedList() {
  return {
    head: null,
    tail: null
  };
}

export function pushSingle(list, value) {
  let node = createNode(value);
  if (list.head) {
    list.tail.next = node;
    list.tail = node;
  }
  else {
    list.head = node;
    list.tail = node;
  }
}

export function push(list) {
  for (let i = 1; i < arguments.length; ++i) {
    pushSingle(list, arguments[i]);
  }
}
