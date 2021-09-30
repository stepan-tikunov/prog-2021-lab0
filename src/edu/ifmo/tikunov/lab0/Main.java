package edu.ifmo.tikunov.lab0;

public class Main {
	static final int SIZE = 17;
	static final int MAX_A = 18;
	static final int FIRST_CONDITION_NUMBER = 17;
	static final int[] SECOND_CONDITION_NUMBERS = {3, 5, 6, 7, 9, 10, 13, 18};
	static final double MIN_RANDOM = -4.0;
	static final double MAX_RANDOM = 8.0;


	static double getRandomDouble(final double min, final double max) {
		final double range = max - min;
		final double random = Math.random(); // A number in range [0.0; 1.0)

		return min + random * range;
	}

	static boolean arrayContainsNumber(final int number, final int[] array) {
		boolean result = false;
		for (int current : array) {
			if (current == number) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[SIZE];
		double[] x = new double[SIZE];
		double[][] y = new double[SIZE][SIZE];

		for (int i = 0; i < SIZE; ++i) {
			a[i] = MAX_A - i;
			x[i] = getRandomDouble(MIN_RANDOM, MAX_RANDOM);
		}

		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (a[i] == FIRST_CONDITION_NUMBER) {
					y[i][j] = 1. - Math.tan(Math.PI * (.5 + x[j]));
					y[i][j] *= y[i][j];
				} else if (arrayContainsNumber(a[i], SECOND_CONDITION_NUMBERS)) {
					y[i][j] = Math.log(Math.pow(Math.sin(Math.abs(x[j])), 2.));
				} else {
					y[i][j] = 2. * x[j] * (.25 - Math.cos(Math.log(Math.abs(x[j]))));
					y[i][j] *= y[i][j];
				}
			}
		}

		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				System.out.printf("%12.5f ", y[i][j]);
			}
			System.out.println();
		}
	}
}
