package Q3_01_Three_in_One;

import java.util.EmptyStackException;

import CtCILibrary.AssortedMethods;

public class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	/* Push value onto stack. */
	public void push(int stackNum, int value) throws FullStackException {
		/* Check that we have space for the next element */
		if (isFull(stackNum)) { 
			throw new FullStackException();
		}
		
		/* Increment stack pointer and then update top value. */		
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;	
	}

	/* Pop item from top stack. */
	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex]; // Get top
		values[topIndex] = 0; // Clear 
		sizes[stackNum]--; // Shrink
		return value;
	}

	/* Return top element. */
	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}		
		return values[indexOfTop(stackNum)];
	}

	/* Return if stack is empty. */
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	/* Return if stack is full. */
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	/* Returns index of the top of the stack. */
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}	
	
	public int[] getValues() {
		return values;
	}
	
	public int[] getStackValues(int stackNum) {
		int[] items = new int[sizes[stackNum]];
		for (int i = 0; i < items.length; i++) {
			items[i] = values[stackNum * stackCapacity + i];
		}
		return items;
	}
	
	public String stackToString(int stackNum) {
		int[] items = getStackValues(stackNum);
		return stackNum + ": " + AssortedMethods.arrayToString(items);
	}	
}
