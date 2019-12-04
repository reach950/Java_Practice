package com.example.data_structure_and_algorithm;

public class LoopArrayQueue {
	
	private String[] items;
	private int size;
	private int head;
	private int tail;

	public LoopArrayQueue(int size) {
		this.items = new String[size];
		this.size = size;
		this.head = 0;
		this.tail = 0;
	}
	
	public boolean enqueue(String item){
		if(head == (tail + 1) % size){
			return false;
		}
		items[tail] = item;
		tail = (tail + 1) % size;
		return true;
	}
	
	public String dequeue(){
		if(head == tail){
			return null;
		}
		String temp = items[head];
		tail = (tail + 1) % size;
		return temp;
	}

}
