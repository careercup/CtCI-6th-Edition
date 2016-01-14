#O(N)
class Node(object):
    def __init__(self, data, next):
        self.data = data
        self.next = next

class SinglyLinkedList(object):
    head = None
    tail = None

    def printList(self):
        current = self.head
        while current is not None:
            print current.data, '->',
            current = current.next
        print None

    def insert(self, data):
        node = Node(data, None)
        if self.head is None:
            self.tail = self.head = node
        else:
            self.tail.next = node
        self.tail = node

    def kthToLast(self, k):
        pointer1 = pointer2 = self.head
        for x in range(0, k):
            if pointer1 is not None:
                pointer1 = pointer1.next
            else:
                return null
        while pointer1 is not None:
            pointer1 = pointer1.next
            pointer2 = pointer2.next

        print pointer2.data

s = SinglyLinkedList()
s.insert(31)
s.insert(98)
s.insert(31)
s.insert(98)
s.insert(3)
s.insert(8)
s.printList()
s.kthToLast(2)
