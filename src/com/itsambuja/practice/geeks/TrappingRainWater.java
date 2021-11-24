package com.itsambuja.practice.geeks;

/**
 * @author ambujaak
 *
 * @problem Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

	public static int maxWater(int[] arr, int n) {
		int result = 0;
		
		for(int i=1; i<n-1; i++) {
			int left = arr[i];
			for(int j = 0; j<i; j++) {
				left = Math.max(left, arr[j]);
			}
			
			int right = arr[i];
			for(int j=i + 1; j <n; j++) {
				right = Math.max(right, arr[j]);
			}
			
			result += Math.min(left, right) - arr[i];
		}
		
		return result;
	}
	
	public static int maxWater2(int[] arr, int n) {
		int result = 0;
		
		int left  = 0,right = 0;
		
		int l =0, h = n - 1;
		
		while(l <= h) {
			if(arr[l] < arr[h]) {
				if(arr[l] > left) {
					left = arr[l];
				} else {
					result += left - arr[l];
				}
				l++;
			}else {
				if(arr[h] > right) {
					right = arr[h];
				} else {
					result += right -arr[h];
				}
				h--;
			}
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0,
                1, 3, 2, 1, 2, 1};
		int n = arr.length;
		
		System.out.println(maxWater2(arr, n));

	}

}
