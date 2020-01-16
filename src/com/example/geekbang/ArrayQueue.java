package com.example.geekbang;

public class ArrayQueue {
	private String[] items;
	private int size;
	private int head;
	private int tail;

	public ArrayQueue(int size) {
		this.items = new String[size];
		this.size = size;
		this.head = 0;
		this.tail = 0;
	}
	
	public boolean enqueue(String item){
		if(tail == size){
			if(head == 0){
				return false;
			}
			for(int i=head; i<tail; i++){
				items[i-head] = items[i];
			}
			tail -= head;
			head = 0;
		}
		items[tail] = item;
		tail++;
		return true;
	}

	public String dequeue(){
		if(head == tail){
			return null;
		}
		String temp = items[head];
		head++;
		return temp;
	}
}
