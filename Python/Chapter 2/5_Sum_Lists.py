from LinkedList import LinkedList


def sum_lists(ll_a, ll_b):
    n1, n2 = ll_a.head, ll_b.head
    ll = LinkedList()
    carry = 0
    while n1 or n2:
        result = carry
        if n1:
            result += n1.value
            n1 = n1.next
        if n2:
            result += n2.value
            n2 = n2.next

        ll.add(result % 10)
        carry = result // 10

    if carry:
        ll.add(carry)

    return ll


def sum_lists_followup(ll_a, ll_b):
    # Pad the shorter list with zeros
    if len(ll_a) < len(ll_b):
        for i in range(len(ll_b) - len(ll_a)):
            ll_a.add_to_beginning(0)
    else:
        for i in range(len(ll_a) - len(ll_b)):
            ll_b.add_to_beginning(0)

    # Find sum
    n1, n2 = ll_a.head, ll_b.head
    result = 0
    while n1 and n2:
        result = (result*10) + n1.value + n2.value
        n1 = n1.next
        n2 = n2.next

    # Create new linked list
    ll = LinkedList()
    ll.add_multiple([int(i) for i in str(result)])

    return ll


ll_a = LinkedList()
ll_a.generate(4, 0, 9)
ll_b = LinkedList()
ll_b.generate(3, 0, 9)
print(ll_a)
print(ll_b)
print(sum_lists(ll_a, ll_b))
print(sum_lists_followup(ll_a, ll_b))
