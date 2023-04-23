package Q3_03_Stack_of_Plates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks2 {
	List<Stack<Integer>> stacks;
	int size;
	
	public SetOfStacks2(int capacity) {
		stacks = new ArrayList<>();
		this.size = capacity;
	}
	
	public boolean isEmpty() {
		return stacks.isEmpty();
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return stacks.get(stacks.size()-1).peek();
	}
	
	public void push(int data) {
		//if list of stacks empty, Add stack
		if(isEmpty()) {
			stacks.add(new Stack<>());
		}
		Stack<Integer> current = stacks.get(stacks.size()-1);
		//Check if stack is full per size constraint. Below line can be simplified to isFull method if required
		if(!(current.size()<this.size)){
			stacks.add(new Stack<>());
			current = stacks.get(stacks.size()-1);
		}
		current.push(data);
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Stack<Integer> current = stacks.get(stacks.size()-1);
		int val = current.pop();
		
		if(current.isEmpty()) {
			stacks.remove(current);
		}
		return val;
		
	}
	
	public int popAt(int stackNo) {
		return stacks.get(stackNo-1).pop();
	}
}
