package com.example.geekbang;

public class Greedy {
	//给定一个包含负数的整数数组，返回最大的子数组之和
	public static int findMaxSum(int[] list){
		int max = 0;
		int tempSum = 0;
		for(int i:list){
			tempSum += i;
			if(tempSum > max){
				max = tempSum;
			}else if(tempSum < 0){
				tempSum = 0;
			}
		}
		return max;
	}
	
	public static int findMaxSum1(int[] list){
		int max = 0;
		for(int i=0; i<list.length; i++){
			int tempSum = 0;
			for(int j=i; j<list.length; j++){
				tempSum += list[j];
				if(tempSum > max){
					max = tempSum;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] testList = {1, 3, -4, 3, -1, 7, -2, 5};
		System.out.println(findMaxSum1(testList));
	}

}
