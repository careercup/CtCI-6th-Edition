from LinkedList import LinkedList


def loop_detection(ll):
    fast = slow = ll.head

    while fast and fast.next and fast is not slow:
        fast = fast.next.next
        slow = slow.next

    if fast is None or fast.next is None:
        return None

    slow = ll.head
    while fast is not slow:
        fast = fast.next
        slow = slow.next

    return fast
