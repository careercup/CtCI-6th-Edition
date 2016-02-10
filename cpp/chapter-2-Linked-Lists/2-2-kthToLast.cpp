/**
 *  Cracking the coding interview edition 6
 *  Problem 2.2
 *  Return kth to last
 *  Implement an algorithm to find the kth to last element of a singly linked list.
 *  We can assume we are not provided the length of the list.
 *
 *  Approaches:
 *  1. Iterative:
 *  	 Use two pointers
 *  	 Move first pointer k places.
 *  	 Now move second pointer(from start) and first pointer (from k+1) simultanously.
 *  	 When second pointer would have reached end, first pointer would be at kth node.
 *
 *  2. Recursive:
 *  	 Maintain an index to keep track of node.
 *  	 Solve the problem for n-1 nodes and add 1 to index.
 *  	 Since each parent call is adding 1, when counter reaches k,
 *  	 we have reached length-k node from start, which is kth node from last.
 */

#include <iostream>

struct Node {
  int data;
  Node * next;
  Node(int d) : data{ d }, next{ nullptr } { }
};


/**
 * Insert to the head of the list
 * @param head - Current head of list
 * @param data - new node's data
 */
void insert( Node * & head, int data ) {
  Node * newNode = new Node(data);
  newNode->next = head;
  head = newNode;
}

/**
 * [deleteList - delete the entire list]
 * @param head - head of the list
 */
void deleteList( Node * & head ) {
  Node * nextNode;
  while(head) {
    nextNode = head->next;
    delete(head);
    head = nextNode;
  }
}

/**
 * printList - Helper routine to print the list
 * @param head - Current head of the list.
 */
void printList( Node * head ) {
  while(head) {
    std::cout << head->data << "-->";
    head = head->next;
  }
  std::cout << "null" << std::endl;
}

/**
 * [kthToLastHelper - helper routine to find nth node for recursive approach
 * @param  head  - head of the list
 * @param  k     - the k value for finding kth element from last of the list.
 * @param  i     - an index maintained to keep track of current node.
 * @return       - kth node from last.
 */
Node * kthToLastHelper( Node * head, int k , int & i) {
  if ( head == nullptr ) {
    return nullptr;
  }

  Node * node = kthToLastHelper(head->next, k, i);
  i = i + 1;
  //if we have solved problem k times from last.
  if ( i == k ) {
    return head;
  }
  return node;
}

/**
 * kthToLastRecursive - Recursive approach for finding kth to last element of list.
 * @param  head  - head of node
 * @param  k     - the k value for finding kth element from last of the list.
 * @return       - kth node from last.
 */
Node * kthToLastRecursive( Node * head, int k ) {
  int i = 0;
  return kthToLastHelper(head, k, i);
}

/**
 * kthToLastIterative -  Iterative approach for finding kth to last element of list.
 * @param  head  - head of node
 * @param  k     - the k value for finding kth element from last of the list.
 * @return       - kth node from last.
 */
Node * kthToLastIterative( Node * head, int k ) {
  if ( head == nullptr ) {
    return head;
  }

  Node * ptr1 = head;
  Node * ptr2 = head;

  int i = 0;
  while( i < k && ptr1 ) {
    ptr1 = ptr1->next;
    ++i;
  }

  //out of bounds
  if ( i < k ) {
    return nullptr;
  }

  while( ptr1 != nullptr ) {
    ptr1 = ptr1->next;
    ptr2 = ptr2->next;
  }

  return ptr2;
}



int main() {
  Node * head = nullptr;
  for ( int i = 7; i > 0; i-- ) {
    insert(head, i);
  }
  std::cout << "List: ";
  printList(head);

  std::cout << "4th node from last (Recursive) : ";
  Node *node4 = kthToLastRecursive(head, 4);
  if ( node4 != nullptr ) {
    std::cout << node4->data << std::endl;
  } else {
    std::cout << "NULL NODE\n";
  }

  std::cout << "4th node from last (Iterative) : ";
  node4 = kthToLastIterative(head, 4);
  if ( node4 != nullptr ) {
    std::cout << node4->data << std::endl;
  } else {
    std::cout << "NULL NODE\n";
  }

  deleteList(head);

  return 0;
}
