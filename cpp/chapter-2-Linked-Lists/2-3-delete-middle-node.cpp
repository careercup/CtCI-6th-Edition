/**
 * Cracking the coding interview - edition 6
 * Problem 2.3 Delete middle node:
 * Implement an algorithm to delete a node in the middle of a singly linked list.
 * We are given pointer to that node.
 *
 * Approach:
 * In order to remove a node 'A' from a list, We will need to connect pointer of
 * A's previous node to A's next node. Here we don't have access to previous node.
 * However, we have pointer to that node, we can copy the data of next node to
 * the pointed node and then remove the next node.
 * Assumption here is that we are not given last node of the list for deletion.
 */

#include <iostream>

struct Node {
  char data;
  Node * next;
  Node( char c ) : data{ c }, next{ nullptr } { }
};

/**
 * [printList - Helper routine to print the list]
 * @param head [head of the list]
 */
void printList( Node * head ) {
  while( head ) {
    std::cout << head->data << "-->";
    head = head->next;
  }
  std::cout << "nullptr" << std::endl;
}

/**
 * [deleteNode - delete the "node" from the list]
 * @param node [node to be deleted]
 */
void deleteNode( Node * node ) {
  if ( node == nullptr || node->next == nullptr ) {
    return;
  }
  Node * nextNode = node->next;
  node->data = nextNode->data;
  node->next = nextNode->next;
  delete nextNode;
}

int main() {
  Node * head = new Node('a');
  head->next = new Node('b');
  head->next->next = new Node('c');
  head->next->next->next = new Node('d');
  head->next->next->next->next = new Node('e');
  std::cout << "List before deletion:\n";
  printList(head);
  std::cout << "Deleting node containing data as 'c'\n";
  deleteNode(head->next->next);
  std::cout << "List after deletion:\n";
  printList(head);
  return 0;
}
