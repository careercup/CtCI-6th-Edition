#include <iostream>
using namespace std;

struct node {
	node * next;
	int data;
};

node* nthToLast(node* head, int k, int& i) {
	if (head == NULL) {
		return NULL;
	}
	node * nd = nthToLast(head->next, k, i);
	i = i + 1;
	if (i == k) {
		return head;
	}
	return nd;
}

node* nthToLast(node* head, int k) {
	int i = 0;
	return nthToLast(head, k, i);
}

node* createList(int count) {
	node* head = new node();
	head->data = 0;
	node* last = head;
	for (int i = 1; i < count; i++) {
		node* n = new node();
		n->data = i;
		last->next = n;
		last = n;
	}
	return head;
}

void printList(node* head) {
	while (head != NULL) {
		printf("%d", head->data);
		head = head->next;
	}
}

int main() {
	int count = 5;
	node* head = createList(count);
	printList(head);
	printf("\n");
	for (int k = 0; k <= count; k++) {
		node* n = nthToLast(head, k);
		if (n != NULL) {
			int data = n->data;
			printf("%d: ", k);
			printf("%d", n->data);
			printf("\n");
		}
	}
	return 0;
}