'use strict';

class TreeNode {
  constructor(value) {
    this.val = value;
    this.parent = this.left = this.right = null;
  }
}

export class Tree {
  constructor() {
    this.root = null;
  }

  add(value) {
    let node = new TreeNode(value);
    if (!this.root) {
      this.root = node;
    }
    else {
      let n = this.root,
        branch;
      while (n) {
        branch = value < n.val ? 'left' : 'right';
        if (!n[branch]) {
          break;
        }
        n = n[branch];
      }
      node.parent = n;
      n[branch] = node;
    }
  }
}

class LinkedListNode {
  constructor(value, next) {
    this.val = value;
    this.next = next || null;
  }
}

export class LinkedList {
  constructor() {
    this.head = this.tail = null;
  }

  prepend(value) {
    if (!this.head) {
      this.head = this.tail = new LinkedListNode(value);
    }
    else {
      this.head = new LinkedListNode(value, this.head);
    }
  }

  append(value) {
    if (!this.head) {
      this.head = this.tail = new LinkedListNode(value);
    }
    else {
      this.tail = this.tail.next = new LinkedListNode(value);
    }
  }

  toArray() {
    let arr = [],
      node = this.head;
    while (node) {
      arr.push(node.val);
      node = node.next;
    }
    return arr;
  }
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
