package edu.unca.csci333;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		int[] a = {10,9,8,7,6,5,4,3,2,1,0};
		int[] b = {100,-11,11};
		int[] c = {1,1,-1,-1,7,1,1,9,2};
		int[] d = {41,23,6};
		
		int[][] test = {a,b,c,d};
		
		for(int i=0; i < test.length; i++) {
			System.out.print("Regular quicksort input: ");
			printArray(test[i]);
			int[] temp = test[i].clone();
			quicksort(test[i], 0, test[i].length-1);
			System.out.print("Regular quicksort output: ");
			printArray(test[i]);
			System.out.print("Randomized quicksort input: ");
			printArray(temp);
			randomizedQuicksort(temp, 0, temp.length-1);
			System.out.print("Randomized quicksort output: ");
			printArray(temp);
			System.out.println("~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ~*~ ");
		}
		
	}
	
	/**
	 * Sorts an array recursively
	 * @param A array to be sorted
	 * @param p first index of array subset to be sorted
	 * @param r	last index of array subset to be sorted
	 */
	private static void quicksort(int[] A, int p, int r) {
		if(p < r) { 
			int q = partition(A, p, r);
			quicksort(A, p, q-1);	// recurse through left subproblem
			quicksort(A, q+1, r);	// recurse through right subproblem
		}
	}
	
	/**
	 * Sorts an array using a random pivot
	 * @param A array to be sorted
	 * @param p first index of array subset to be sorted
	 * @param r	last index of array subset to be sorted
	 */
	private static void randomizedQuicksort(int[] A, int p, int r) {
		if(p < r) { 
			Random rand = new Random();
			int z = rand.nextInt(r-p + 1) + p;
			swap(A, r, z);
			int q = partition(A, p, r);
			randomizedQuicksort(A, p, q-1);	// recurse through left subproblem
			randomizedQuicksort(A, q+1, r);	// recurse through right subproblem
		}
	}
	
	/**
	 * Divides an array in 2, elems left of pivot are less than the pivot value and elems to the right are greater
	 * @param A array
	 * @param p first index of array or array subset
	 * @param r last index of array or array subset
	 * @return
	 */
	private static int partition(int[] A, int p, int r) {
		int x = A[r];	// choose pivot value as right-most elem
		int i = p-1;
		for(int j = p; j < r; j++) {
			if(A[j] <= x) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i+1, r);
		return i+1;
	}
	
	/**
	 * switches two elems in the array
	 * @param A array
	 * @param i index of first elem
	 * @param j index of second elem
	 */
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	/**
	 * Prints array 
	 * @param array
	 */
	private static void printArray(int[] array) {
		String print = "[";
		for (int i=0; i<array.length-1; i++) {
			print += array[i] + ", " ;
		}
		print += array[array.length-1] + "]";
		System.out.println(print);
	}
}
