
public class require {
	public static void main(String[] args) {

        /****Test****/ 
        // 1
        int[] arrNum = {-4, 22, 3, 1, 89, 37, 62, -43, -24, -25};
        int maxNum = getMax(arrNum);
        int minNum = getMin(arrNum);
        System.out.printf("maxNum is %d, minNum is %d \n", maxNum, minNum);
		// 2
        int maxNum1 = getMaxAndSecondMaxNum(arrNum)[0];
        int secMaxNum = getMaxAndSecondMaxNum(arrNum)[1];
        int[] arr = getMaxAndSecondMaxNum(arrNum);
        System.out.printf("maxNum is %d, secMaxNum is %d \n", maxNum1, secMaxNum);
        // 3
        int count = getCountFromIntegerArray(arrNum);
        System.out.printf("The count is %d \n", count);
	}

/* 
1.Given an integer array, 
output the maximum and minimum number.
You are not allowed to sort the array using existing API
*/
    public static int getMax(int[] arr) {
    	int maxNum = arr[0];
    	for (int num: arr) {
    		if (num > maxNum) {
    			maxNum = num;
    		}
    	}
    	return maxNum;
    }

    public static int getMin(int[] arr) {
    	int minNum = arr[0];
    	for (int num: arr) {
    		if (num < minNum) {
    			minNum = num;
    		}
    	}
    	return minNum;
    }

/*
2.Given an integer array, 
output the first maximum and second maximum number.
 You are not allowed to sort the array using existing API*/

    public  static int[] getMaxAndSecondMaxNum(int[] arr) {
    	int maxNum = getMax(arr);
    	int secMaxNum = getMin(arr);
    	for (int num: arr) {
    		if (num > secMaxNum && num < maxNum) {
    			secMaxNum = num;
    		}
    	}
        int[] result = {maxNum, secMaxNum};
        return result;
    } 

/*
3.Given an integer array, 
count the unique combinations of three numbers such that 
sum of them is 0. For example, 
if we have [-1, -2, 3, -4, -5, 9, 10, 11], 
the expected count should be 2, which are -1, -2, 3 and -4, -5, 9.
 You can assume there is no duplicated element in the array
*/

	public static int getCountFromIntegerArray(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				int b = arr[j];
	                for (int k = j + 1; k < arr.length; k++) {
	                	int c = arr[k];
	                	int sum = 0;
	                	if (a + b + c == sum) {
							count ++;
	                	}
	                }
			}
			
		}
		return count;
	}

}

