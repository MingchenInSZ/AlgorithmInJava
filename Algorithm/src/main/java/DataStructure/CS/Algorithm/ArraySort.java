package DataStructure.CS.Algorithm;

public class ArraySort {

	/**
	 * bubble sort imp
	 * 
	 * @param array
	 *            int array
	 * @param asc
	 *            void 2015年8月21日
	 */
	public static void bubbleSort(int[] array, boolean asc) {
		boolean swap = true;
		for (int i = array.length - 1; i > 0 && swap; i--) {
			for (int j = 0; j < i; j++) {
				swap = false;
				if (asc) {
					if (array[j] > array[j + 1]) {
						int temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						swap = true;
					}

				} else {
					if (array[j] < array[j + 1]) {
						int temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						swap = true;
					}

				}
			}
		}
		display(array);
	}

	/**
	 * 
	 * @param array
	 *            double array
	 * @param asc
	 *            void 2015年8月21日
	 */
	public static void bubbleSort(double[] array, boolean asc) {
		boolean swap = true;
		for (int i = array.length - 1; i > 0 && swap; i--) {
			for (int j = 0; j < i; j++) {
				swap = false;
				if (asc) {
					if (array[j] > array[j + 1]) {
						double temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						swap = true;
					}

				} else {
					if (array[j] < array[j + 1]) {
						double temp = array[j + 1];
						array[j + 1] = array[j];
						array[j] = temp;
						swap = true;
					}

				}
			}
		}
		display(array);
	}

	/**
	 * 
	 * @param array
	 * @param asc
	 *            void
	 * 
	 *            2015年8月21日
	 */
	public static void selectionSort(int[] array, boolean asc) {
		int max = -1,min = -1;
		for(int i = 0;i<array.length - 1;i++){
			min = i;max = i;
			for (int j = i + 1; j < array.length; j++) {
				if(array[j]<array[min]){
					min = j;
				}
				if (array[j] > array[max]) {
					max = j;
				}
			}
			if (asc) {
				if (min != i) {
					int temp = array[i];
					array[i] = array[min];
					array[min] = temp;
				}
			} else {
				if (max != i) {
					int temp = array[i];
					array[i] = array[max];
					array[max] = temp;
				}
			}
		}
		display(array);
	}

	/**
	 * 
	 * @param array
	 * @param asc
	 *            void
	 * 
	 *            2015年8月21日
	 */
	public static void selectionSort(double[] array, boolean asc) {
		int max = -1, min = -1;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			max = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
				if (array[j] > array[max]) {
					max = j;
				}
			}
			if (asc) {
				if (min != i) {
					double temp = array[i];
					array[i] = array[min];
					array[min] = temp;
				}
			} else {
				if (max != i) {
					double temp = array[i];
					array[i] = array[max];
					array[max] = temp;
				}
			}
		}
		display(array);
	}

	/**
	 * Merge sort imp
	 * 
	 * @param array
	 *            source array to sort
	 * @param start
	 *            start index default 0
	 * @param end
	 *            end index default length of the array -1
	 * @param temp
	 *            temporary array void
	 * 
	 *            2015年8月22日
	 */
	public static void mergeSort(int[] array, int start, int end, int[] temp) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid, temp);
			mergeSort(array, mid + 1, end, temp);
			merge(array, start, mid, end, temp);
		}
	}

	/**
	 * Merge certain segment of the array
	 * 
	 * @param array
	 *            the source array to sort
	 * @param start
	 *            start index
	 * @param mid
	 *            mid index
	 * @param end
	 *            end index
	 * @param temp
	 *            temp array to store the temporary sorted void
	 * 
	 *            2015年8月22日
	 */
	public static void merge(int[] array, int start, int mid, int end,int [] temp) {
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		while(i<=mid){
			temp[k++] = array[i++];
		}
		while (j <= end) {
			temp[k++] = array[j++];
		}
		for (i = 0; i < k; i++) {
			array[start + i] = temp[i];
		}
	}

	/**
	 * Shell sort imp
	 * 
	 * @param array
	 *            source array to sort void
	 * 
	 *            2015年8月22日
	 */
	public static void shellSort(int[] array) {
		int step = 0;
		for (step = array.length / 2; step > 0; step /= 2) {
			for (int i = step; i < array.length; i++) {
				for (int j = i - step; j >= 0; j -= step) {
					if (array[j + step] < array[j]) {
						int temp = array[j + step];
						array[j + step] = array[j];
						array[j] = temp;
					}
				}
			}
		}
		display(array);
	}

	/**
	 * Heap sort imp
	 * 
	 * @param array
	 *            source array to sort void
	 * 
	 *            2015年8月22日
	 */
	public static void heapSort(int[] array) {
		buildHeap(array);
		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapAdjust(array, 0, i - 1);
		}
		display(array);
	}

	/**
	 * Build heap
	 * 
	 * @param array
	 *            source array
	 * 
	 *            2015年8月22日
	 */
	private static void buildHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			heapAdjust(array, i, array.length - 1);
		}
	}

	/**
	 * Heap adjust
	 * 
	 * @param array
	 *            source array
	 * @param i
	 *            index
	 * @param size
	 *            size to adjust
	 * 
	 *            2015年8月22日
	 */
	private static void heapAdjust(int[] array, int i, int size) {
		int left = 2 * i, right = 2 * i + 1, max = i;
		if (i <= size / 2) {
			if (left <= size && array[left] > array[max]) {
				max = left;
			}
			if (right <= size && array[right] > array[max]) {
				max = right;
			}
			if (max != i) {
				int temp = array[i];
				array[i] = array[max];
				array[max] = temp;
				heapAdjust(array, max, size);
			}
		}
	}

	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int key = array[left];
			int low = left, high = right;
			while (low < high) {
				while (low < high && array[high] > key) {
					high --;
				}
				array[low] = array[high];
				while (low < high && array[low] < key) {
					low++;
				}
				array[high] = array[low];
			}
			array[low] = key;
			quickSort(array, left, low - 1);
			quickSort(array, low + 1, right);
		}
	}

	/**
	 * 
	 * @param array
	 *            void 2015年8月21日
	 */
	public static void display(int[] array) {
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param array
	 *            void 2015年8月21日
	 */
	public static void display(double[] array) {
		for (double a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
