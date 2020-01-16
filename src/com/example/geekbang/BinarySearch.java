package com.example.geekbang;

public class BinarySearch {
	
	static int binarySearchLoop(int[] list, int item){
		int left = 0;
		int right = list.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(item < list[mid]){
				right = mid - 1;
			}else if(item > list[mid]){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	static int binarySearchRec(int[] list, int item){
		return binarySearchRecHelper(list, item, 0, list.length-1);
	}
	
	static int binarySearchRecHelper(int[] list, int item, int left, int right){
		if(left > right){
			return -1;
		}
		int mid = left + (right - left) / 2;
		if(item < list[mid]){
			return binarySearchRecHelper(list, item, left, mid-1);
		}else if(item > list[mid]){
			return binarySearchRecHelper(list, item, mid+1, right);
		}else{
			return mid;
		}
	}
	
	static int binarySearchFirstGe(int[] list, int value){
		int left = 0;
		int right = list.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(list[mid] < value){
				left = mid + 1;
			}else{
				if(mid == 0 || list[mid-1] < value){
					return mid;
				}else{
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] testArray = {1,3,4,8,11,15,23,25};
		System.out.println(binarySearchFirstGe(testArray, 9));
	}
}
