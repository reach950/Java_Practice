package com.example.geekbang;

public class ArrayListFixedSize {
	
	private int[] array;
	private int size;
	private int i;
	

	public ArrayListFixedSize(int size) {
		this.array = new int[size];
		this.size = size;
		this.i = 0;
	}
	
	public boolean insert(int value){
		if(this.i >= this.size){
			return false;
		}
		for(int j=this.i; j>=0; j--){
			if(this.array[j] > value){
				this.array[j+1] = this.array[j];
			}else{
				this.array[j+1] = value;
				break;
			}
		}
		this.i++;
		return true;
	}
	
}
