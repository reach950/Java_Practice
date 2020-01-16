package com.example.geekbang;

public class Heap {
	  private int[] a; // 数组，从下标 1 开始存储数据
	  private int n;  // 堆可以存储的最大数据个数
	  private int count; // 堆中已经存储的数据个数

	  public Heap(int capacity) {
	    a = new int[capacity + 1];
	    n = capacity;
	    count = 0;
	  }

	  public void insert(int data) {
		  if(this.count >= this.n){
			  return;
		  }
		  this.count++;
		  a[count] = data;
		  int i = count;
		  while(i/2 > 0 && a[i] > a[i/2]){
			  int temp = a[i/2];
			  a[i/2] = a[i];
			  a[i] = temp;
			  i = i/2;
		  }
	  }
	  
	  public static void main(String[] args){
		  Heap h = new Heap(10);
		  h.insert(9);
		  h.insert(3);
		  h.insert(23);
		  h.insert(16);
		  h.insert(11);
		  for(int i: h.a){
			  System.out.print(i + " ");
		  }
	  }
	  
	  public void removeMax() {
		  if (this.count == 0) return; // 堆中没有数据
		  a[1] = a[this.count];
		  --this.count;
		  heapify(a, this.count, 1);
		}

		private void heapify(int[] a, int n, int i) { // 自上往下堆化
		  while (true) {
		    int maxPos = i;
		    if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
		    if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
		    if (maxPos == i) break;
			int temp = a[maxPos];
			a[maxPos] = a[i];
			a[i] = temp;
		    i = maxPos;
		  }
		}

}

