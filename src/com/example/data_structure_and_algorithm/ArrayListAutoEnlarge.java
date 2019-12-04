package com.example.data_structure_and_algorithm;

public class ArrayListAutoEnlarge {
	
	int array[] = new int[10];
	int len = 10;
	int i = 0;
	
	void add(int element){
		if(i >= len){
			int temp_array[] = new int[len * 2];
			for(int j=0; j<len; j++){
				temp_array[j] = array[j];
			}
			array = temp_array;
			len = len * 2;
		}
		array[i] = element;
		i++;
	}
}