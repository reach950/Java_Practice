package com.example.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Example {

	int[] arr;

	public static void main(String[] args) {

//		int[] arr1 = { 2, 4, 5, 7, 9, 11, 15 };
//		int[] arr2 = { 3, 5, 8, 10, 11, 13, 14 };
//		new Example().mergeSortedArray(arr1, arr2, arr1.length, arr2.length);
//		reserveNumber(198720030);
		System.out.println(md5("123"));
	}

	public void mergeSortedArray(int[] arr1, int[] arr2, int n, int m) {
		int index1 = n - 1;
		int index2 = m - 1;
		int newIndex = n + m - 1;
		arr = new int[n + m];
		while (index1 >= 0 && index2 >= 0) {
			if (arr1[index1] >= arr2[index2]) {
				arr[newIndex] = arr1[index1];
				index1--;
			} else {
				arr[newIndex] = arr2[index2];
				index2--;
			}
			newIndex--;
		}
		if (index1 == 0) {
			arr[newIndex] = arr1[index1];
		} else {
			arr[newIndex] = arr2[index2];
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void reserveNumber(int inputNumber) {
		int sum = 0;
		List<Integer> mList = new ArrayList<Integer>();
		while (inputNumber > 0) {
			int temp = inputNumber % 10;
			mList.add(temp);
			inputNumber = inputNumber / 10;
		}
		/* mList.add(inputNumber); */
		for (int i = 0; i < mList.size(); i++) {
			int temp = mList.get(i) * (int) Math.pow(10, mList.size() - i - 1);
			sum = sum + temp;
		}
		System.out.println(sum);
	}

	public static String md5(String text) {
		byte[] secretBytes = null;
		try {
		  MessageDigest md = MessageDigest.getInstance("MD5");
		  md.update(text.getBytes());
		      secretBytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
		      throw new RuntimeException("û��md5����㷨��");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
	}

}