package com.example.geekbang;

public class ArrayStack {
	private String[] items;
	private int size;
	private int count; //栈中元素个数
	
	public ArrayStack(int size){
		this.items = new String[size];
		this.size = size;
		this.count = 0;
	}
	
	public boolean push(String item){
		if(count == size){
			return false;
		}
		items[count] = item;
		count++;
		return true;
	}
	
	public String pop(){
		if(count == 0){
			return null;
		}
		String temp = items[count - 1];
		count--;
		return temp;
	}
	
	public static void main(String[] args){
		ArrayStack arrayStack1 = new ArrayStack(5);
		arrayStack1.push("a");
		arrayStack1.push("b");
		System.out.println(arrayStack1.items[1]);
		
	}
}
