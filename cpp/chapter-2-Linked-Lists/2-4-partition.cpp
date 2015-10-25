/**
 *  Cracking the coding interview edition 6
 *  Problem 2.4 Partition:
 *  Write code to partition linked list around a value x, such that
 *  nodes less than x come before all the nodes greater than or equal to x.
 *  If x is in the list, the values of x only need to be after the elements less
 *  than x.
 *  Example
 *  3-->5-->8-->5-->10-->2-->1 (x = 5)
 *  3-->1-->2-->10-->5-->5-->8
 *
 *  Approach:
 *  Start with first node, and add every thing bigger or equal to x at tail
 *  and smaller values at head.
 */

#include <iostream>
#include <random>

struct Node {
  int data;
  Node * next;
  Node( int d ) : data{ d }, next{ nullptr } { }
};


/**
 * [insert - helper routine to insert a new node with data]
 * @param head [head of the list]
 * @param data [data of the new node]
 */
void insert( Node * & head, int data ) {
  Node * newNode = new Node(data);
  if ( head == nullptr ) {
    head = newNode;
  } else {
    Node * curr = head;
    while( curr->next ) {
      curr = curr->next;
    }
    curr->next = newNode;
  }
}

/**
 * [printList - helper routine to print the list]
 * @param head [head of the list]
 */
void printList( Node * head ) {
  while ( head ) {
    std::cout << head->data << "-->";
    head = head->next;
  }
  std::cout << "nullptr" << std::endl;
}

/**
 * [partition - routine to partition list around x]
 * @param head [head of the list]
 * @param x    [data around which partition is being done]
 */
void partition( Node * & head , int x ) {
  Node * tail = head;
  Node * curr = head;
  while( curr != nullptr ) {
    Node * nextNode = curr->next;
    if ( curr->data < x ) {
      //insert at head
      curr->next = head;
      head = curr;
    } else {
      // insert at tail
      tail->next = curr;
      tail = curr;
    }
    curr = nextNode;
  }
  tail->next = nullptr;
}

/**
 * [random_range helper routine to generate a random number between min and max (including)]
 * @param  min [min of range]
 * @param  max [max of range]
 * @return     [A random number between min and max]
 */
static inline int random_range(const int min, const int max) {
	std::random_device rd;
	std::mt19937 mt(rd());
	std::uniform_int_distribution<int> distribution(min, max);
	return distribution(mt);
}


int main() {
  Node * head = nullptr;
  for ( int i = 0; i < 10; ++i ) {
		insert(head, random_range(1,9));
	}
  std::cout << "List before partition around 5:\n";
  printList(head);
  partition(head, 5);
  std::cout << "List after partition around 5:\n";
  printList(head);
  return 0;
}
