package Ch03_StacksAndQueues

/** Simulate multiple stacks with one array */
class MultiStack<T> {
    private T[] values
    private int[] sizes
    private int capacity

    def MultiStack(int numberOfStacks, int capacity) {
        this.values = new T[numberOfStacks * capacity]
        this.sizes = new int[numberOfStacks]
        this.capacity = capacity
    }

    void push(int id, T value) {
        sizes[id]++
        values[getLastIndex(id)] = value
    }
    T peek(int id) { values[getLastIndex(id)] }
    T pop(int id) {
        def index = getLastIndex(id)
        def val = values[index]
        values[index] = null
        sizes[id]--
        val
    }
    boolean isEmpty(int id) { getSize(id) == 0 }

    private getLastIndex(int id) {
        def offset = validateId(id) * capacity
        offset + getSize(id) - 1
    }
    private getSize(int id) { assertValid(0..capacity, sizes[validateId(id)]) }
    private validateId(int id) { assertValid(0..<sizes.size(), id) }
    private assertValid(IntRange range, int value) { assert range.contains(value); value }
}