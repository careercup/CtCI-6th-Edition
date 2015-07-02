package Q7_09_Circular_Array;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
	private T[] items;
	private int head = 0;
	
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}
	
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI> {
		private int _current = -1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> circularArray) {
			_items = circularArray.items;
		}
		
		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}
		
		@Override
		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported by CircularArray");
		}
	}
}
