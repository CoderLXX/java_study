public class Fibonacci {
	public static void main(String[] args) {

        int result = calc(20);
		System.out.printf("The result is %d\n", result);

	}

	public static int calc(int number) {
		if (number <= 0) {
			return 0;
		}
		int x = 0;
		int[] result = new int[number + 1];
		while (x < number + 1) {
			if (x == 0 || x == 1) {
	            result[x] = x;
			}
			else {
				result[x] = result[x-1] + result[x-2];
			}
            x++;
		}
		return result[number];
	}
}